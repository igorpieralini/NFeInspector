package me.pieralini.com.model;

import java.util.ArrayList;
import java.util.List;

public class Invoice {
    private Ide ide;
    private Emitter emitter;
    private Recipient recipient;
    private List<Product> products = new ArrayList<>();
    private Taxes taxes;
    private Totals totals;
    private Transport transport;
    private Billing billing;
    private Payment payment;
    private TechContact techContact;
    private String infAdicional;
    private String purchaseOrder;
    private Protocol protocol;

    public Ide getIde() { return ide; }
    public void setIde(Ide ide) { this.ide = ide; }

    public Emitter getEmitter() { return emitter; }
    public void setEmitter(Emitter emitter) { this.emitter = emitter; }

    public Recipient getRecipient() { return recipient; }
    public void setRecipient(Recipient recipient) { this.recipient = recipient; }

    public List<Product> getProducts() { return products; }
    public void addProduct(Product p) { products.add(p); }

    public Taxes getTaxes() { return taxes; }
    public void setTaxes(Taxes taxes) { this.taxes = taxes; }

    public Totals getTotals() { return totals; }
    public void setTotals(Totals totals) { this.totals = totals; }

    public Transport getTransport() { return transport; }
    public void setTransport(Transport transport) { this.transport = transport; }

    public Billing getBilling() { return billing; }
    public void setBilling(Billing billing) { this.billing = billing; }

    public Payment getPayment() { return payment; }
    public void setPayment(Payment payment) { this.payment = payment; }

    public TechContact getTechContact() { return techContact; }
    public void setTechContact(TechContact techContact) { this.techContact = techContact; }

    public String getInfAdicional() { return infAdicional; }
    public void setInfAdicional(String infAdicional) { this.infAdicional = infAdicional; }

    public String getPurchaseOrder() { return purchaseOrder; }
    public void setPurchaseOrder(String purchaseOrder) { this.purchaseOrder = purchaseOrder; }

    public Protocol getProtocol() { return protocol; }
    public void setProtocol(Protocol protocol) { this.protocol = protocol; }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== IDENTIFICATION ===\n").append(ide).append("\n\n");
        sb.append("=== EMITTER ===\n").append(emitter).append("\n\n");
        sb.append("=== RECIPIENT ===\n").append(recipient).append("\n\n");
        sb.append("=== PRODUCTS ===\n");
        for (Product p : products) sb.append(p).append("\n");
        sb.append("\n=== TAXES ===\n").append(taxes).append("\n\n");
        sb.append("=== TOTALS ===\n").append(totals).append("\n\n");
        sb.append("=== TRANSPORT ===\n").append(transport).append("\n\n");
        sb.append("=== BILLING ===\n").append(billing).append("\n\n");
        sb.append("=== PAYMENT ===\n").append(payment).append("\n\n");
        sb.append("=== TECH CONTACT ===\n").append(techContact).append("\n\n");
        sb.append("=== ADDITIONAL INFO ===\n").append(infAdicional).append("\n\n");
        sb.append("=== PURCHASE ===\n").append(purchaseOrder).append("\n\n");
        sb.append("=== PROTOCOL ===\n").append(protocol).append("\n");
        return sb.toString();
    }
}
