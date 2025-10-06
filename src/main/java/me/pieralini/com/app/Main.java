package me.pieralini.com.app;


import me.pieralini.com.model.Invoice;
import me.pieralini.com.service.InvoiceService;

public class Main {
    public static void main(String[] args) {
        String path = args.length > 0 ? args[0] : "src/main/resources/example.xml";
        InvoiceService service = new InvoiceService();
        try {
            Invoice inv = service.readInvoiceFile(path);
            service.printInvoice(inv);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
