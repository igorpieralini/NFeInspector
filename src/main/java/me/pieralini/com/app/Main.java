package me.pieralini.com.app;

import me.pieralini.com.service.InvoiceService;

public class Main {
    public static void main(String[] args) {
        InvoiceService service = new InvoiceService();
        service.readAllFromDirectory("src/main/resources/");
    }
}
