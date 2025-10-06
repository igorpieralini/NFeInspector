package me.pieralini.com.service;



import me.pieralini.com.model.Invoice;
import me.pieralini.com.parser.NFeParser;

import java.io.File;

public class InvoiceService {
    private final NFeParser parser = new NFeParser();

    public Invoice readInvoiceFile(String path) throws Exception {
        File f = new File(path);
        return parser.parse(f);
    }

    public void printInvoice(Invoice invoice) {
        System.out.println(invoice.toString());
    }
}
