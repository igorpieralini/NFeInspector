package me.pieralini.com.service;

import me.pieralini.com.model.*;
import me.pieralini.com.parser.NFeParser;

import java.io.File;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import static me.pieralini.com.utils.ConsoleColors.*;

public class InvoiceService {

    private final NFeParser parser = new NFeParser();
    private final NumberFormat currency = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));

    public Invoice readInvoiceFile(String path) throws Exception {
        File f = new File(path);
        return parser.parse(f);
    }

    public void readAllFromDirectory(String directoryPath) {
        File folder = new File(directoryPath);

        if (!folder.exists() || !folder.isDirectory()) {
            System.out.println(RED_BOLD + "❌ Invalid directory: " + directoryPath + RESET);
            return;
        }

        File[] xmlFiles = folder.listFiles((dir, name) -> name.toLowerCase().endsWith(".xml"));

        if (xmlFiles == null || xmlFiles.length == 0) {
            System.out.println(YELLOW_BOLD + "⚠️ No XML files found in " + directoryPath + RESET);
            return;
        }

        System.out.println(BLUE_BOLD + "\n📂 Found " + xmlFiles.length + " XML files in " + directoryPath + RESET);

        Arrays.stream(xmlFiles).forEach(file -> {
            try {
                System.out.println(PURPLE_BOLD + "\n─────────────────────────────────────────────" + RESET);
                System.out.println(CYAN_BOLD + "📄 Reading file: " + file.getName() + RESET);
                System.out.println(PURPLE_BOLD + "─────────────────────────────────────────────" + RESET);

                Invoice invoice = parser.parse(file);
                printInvoice(invoice);

                System.out.println(GREEN_BOLD + "\n✅ Successfully processed: " + file.getName() + RESET);

            } catch (Exception e) {
                System.out.println(RED_BOLD + "\n❌ Failed to read file: " + file.getName() + RESET);
                e.printStackTrace();
            }
        });

        System.out.println(BLUE_BOLD + "\n🎉 All XML files processed successfully!" + RESET);
    }

    public void printInvoice(Invoice i) {
        printIdentification(i);
        printEmitter(i);
        printRecipient(i);
        printProducts(i);
        printTaxes(i);
        printTotals(i);
        printTransport(i);
        printBilling(i);
        printPayment(i);
        printTechContact(i);
        printAdditional(i);
        printProtocol(i);
    }

    private void printIdentification(Invoice i) {
        System.out.println(BLUE_BOLD + "\n╔════════════════════════════════════════════╗");
        System.out.println("║             🔍 IDENTIFICATION              ║");
        System.out.println("╚════════════════════════════════════════════╝" + RESET);

        Ide ide = i.getIde();
        if (ide != null) {
            System.out.printf("%sNF-e:%s %s | %sNature:%s %s%n", GREEN_BOLD, RESET, ide.getnNF(), CYAN_BOLD, RESET, ide.getNatOp());
            System.out.printf("%sIssue:%s %s | %sModel:%s %s%n", YELLOW_BOLD, RESET, ide.getDhEmi(), CYAN_BOLD, RESET, ide.getMod());
            System.out.printf("%sSeries:%s %s | %sType:%s %s%n", GREEN_BOLD, RESET, ide.getSerie(), CYAN_BOLD, RESET, ide.getTpNF());
            System.out.printf("%sEnvironment:%s %s%n", YELLOW_BOLD, RESET, "1".equals(ide.getTpAmb()) ? "Production" : "Homologation");
        }
    }

    private void printEmitter(Invoice i) {
        System.out.println(BLUE_BOLD + "\n╔════════════════════════════════════════════╗");
        System.out.println("║                 🏢 EMITTER                 ║");
        System.out.println("╚════════════════════════════════════════════╝" + RESET);

        Emitter e = i.getEmitter();
        if (e != null) {
            System.out.printf("%sName:%s %s%n", GREEN_BOLD, RESET, e.getName());
            System.out.printf("%sCNPJ:%s %s | %sIE:%s %s%n", CYAN_BOLD, RESET, e.getCnpj(), CYAN_BOLD, RESET, e.getIe());
            if (e.getAddress() != null) {
                Address a = e.getAddress();
                System.out.printf("%sAddress:%s %s, %s, %s - %s / %s%n", YELLOW_BOLD, RESET,
                        a.getStreet(), a.getNumber(), a.getNeighborhood(), a.getCity(), a.getUf());
            }
        }
    }

    private void printRecipient(Invoice i) {
        System.out.println(BLUE_BOLD + "\n╔════════════════════════════════════════════╗");
        System.out.println("║                👤 RECIPIENT                ║");
        System.out.println("╚════════════════════════════════════════════╝" + RESET);

        Recipient r = i.getRecipient();
        if (r != null) {
            System.out.printf("%sName:%s %s%n", GREEN_BOLD, RESET, r.getName());
            System.out.printf("%sCNPJ/CPF:%s %s%n", CYAN_BOLD, RESET, r.getCnpjOrCpf());
            if (r.getAddress() != null) {
                Address a = r.getAddress();
                System.out.printf("%sAddress:%s %s, %s, %s - %s / %s%n", YELLOW_BOLD, RESET,
                        a.getStreet(), a.getNumber(), a.getNeighborhood(), a.getCity(), a.getUf());
            }
        }
    }

    private void printProducts(Invoice i) {
        System.out.println(BLUE_BOLD + "\n╔════════════════════════════════════════════╗");
        System.out.println("║                 📦 PRODUCTS                ║");
        System.out.println("╚════════════════════════════════════════════╝" + RESET);

        List<Product> products = i.getProducts();
        if (products != null && !products.isEmpty()) {
            for (Product p : products) {
                System.out.printf("%sItem:%s %s | %sCode:%s %s%n", GREEN_BOLD, RESET, p.getItemNumber(), CYAN_BOLD, RESET, p.getCode());
                System.out.printf("  %sDesc:%s %s%n", YELLOW_BOLD, RESET, p.getDescription());
                System.out.printf("  %sQty:%s %.2f %s | %sUnit Value:%s R$%.2f | %sTotal:%s R$%.2f%n",
                        GREEN_BOLD, RESET, p.getQuantity(), p.getUnit(),
                        CYAN_BOLD, RESET, p.getUnitValue(),
                        YELLOW_BOLD, RESET, p.getTotalValue());
            }
        } else {
            System.out.println(YELLOW_BOLD + "⚠️ No products found." + RESET);
        }
    }

    private void printTaxes(Invoice i) {
        System.out.println(BLUE_BOLD + "\n╔════════════════════════════════════════════╗");
        System.out.println("║                   💰 TAXES                 ║");
        System.out.println("╚════════════════════════════════════════════╝" + RESET);

        Taxes t = i.getTaxes();
        if (t != null) {
            if (t.getIcmsMono() != null) {
                TaxICMSMono m = t.getIcmsMono();
                System.out.printf("%sICMS Mono:%s CST=%s | vICMS=%s%n",
                        GREEN_BOLD, RESET, m.getCst(), currency.format(m.getvICMSMonoRet()));
            }
            System.out.printf("%sPIS:%s %s | %sCOFINS:%s %s%n",
                    CYAN_BOLD, RESET, t.getPisCst(), CYAN_BOLD, RESET, t.getCofinsCst());
        } else {
            System.out.println(YELLOW_BOLD + "⚠️ No taxes found." + RESET);
        }
    }

    private void printTotals(Invoice i) {
        System.out.println(BLUE_BOLD + "\n╔════════════════════════════════════════════╗");
        System.out.println("║                 📊 TOTALS                  ║");
        System.out.println("╚════════════════════════════════════════════╝" + RESET);

        Totals t = i.getTotals();
        if (t != null) {
            System.out.printf("%sProducts:%s %s | %sTotal:%s %s%n",
                    GREEN_BOLD, RESET, currency.format(t.getvProd()),
                    CYAN_BOLD, RESET, currency.format(t.getvNF()));
        }
    }

    private void printTransport(Invoice i) {
        System.out.println(BLUE_BOLD + "\n╔════════════════════════════════════════════╗");
        System.out.println("║                🚛 TRANSPORT                ║");
        System.out.println("╚════════════════════════════════════════════╝" + RESET);

        Transport tr = i.getTransport();
        if (tr != null) {
            System.out.printf("%sMode:%s %s%n", GREEN_BOLD, RESET, tr.getModFrete());
            if (tr.getTransporter() != null)
                System.out.printf("%sTransporter:%s %s%n", CYAN_BOLD, RESET, tr.getTransporter().getName());
        }
    }

    private void printBilling(Invoice i) {
        System.out.println(BLUE_BOLD + "\n╔════════════════════════════════════════════╗");
        System.out.println("║                🧾 BILLING                  ║");
        System.out.println("╚════════════════════════════════════════════╝" + RESET);

        Billing b = i.getBilling();
        if (b != null) {
            System.out.printf("%sInvoice:%s %s | %sTotal:%s %s%n",
                    GREEN_BOLD, RESET, b.getnFat(), CYAN_BOLD, RESET, currency.format(b.getvOrig()));
        }
    }

    private void printPayment(Invoice i) {
        System.out.println(BLUE_BOLD + "\n╔════════════════════════════════════════════╗");
        System.out.println("║                💳 PAYMENT                  ║");
        System.out.println("╚════════════════════════════════════════════╝" + RESET);

        Payment p = i.getPayment();
        if (p != null) {
            System.out.printf("%sType:%s %s | %sValue:%s %s%n",
                    GREEN_BOLD, RESET, p.gettPag(), CYAN_BOLD, RESET, currency.format(p.getvPag()));
        }
    }

    private void printTechContact(Invoice i) {
        System.out.println(BLUE_BOLD + "\n╔════════════════════════════════════════════╗");
        System.out.println("║              🧠 TECH CONTACT               ║");
        System.out.println("╚════════════════════════════════════════════╝" + RESET);

        TechContact tc = i.getTechContact();
        if (tc != null) {
            System.out.printf("%sContact:%s %s | %sEmail:%s %s%n",
                    GREEN_BOLD, RESET, tc.getContact(), CYAN_BOLD, RESET, tc.getEmail());
        }
    }

    private void printAdditional(Invoice i) {
        System.out.println(BLUE_BOLD + "\n╔════════════════════════════════════════════╗");
        System.out.println("║            📋 ADDITIONAL INFO              ║");
        System.out.println("╚════════════════════════════════════════════╝" + RESET);

        System.out.println(i.getInfAdicional() != null ? i.getInfAdicional() : "No additional info.");
    }

    private void printProtocol(Invoice i) {
        System.out.println(BLUE_BOLD + "\n╔════════════════════════════════════════════╗");
        System.out.println("║                🪪 PROTOCOL                 ║");
        System.out.println("╚════════════════════════════════════════════╝" + RESET);

        Protocol p = i.getProtocol();
        if (p != null) {
            System.out.printf("%sStatus:%s %s | %sProtocol:%s %s%n",
                    GREEN_BOLD, RESET, p.getcStat(), CYAN_BOLD, RESET, p.getnProt());
        }
    }
}
