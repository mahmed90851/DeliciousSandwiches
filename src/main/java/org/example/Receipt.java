package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Receipt {
    private Order order;

    public Receipt(Order order) {
        this.order = order;
    }

    public void generateReceipt() {
        String receiptContent = formatReceiptContent();
        String fileName = generateFileName();

        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            writer.println(receiptContent);
            System.out.println("Receipt generated successfully!");
        } catch (IOException e) {
            System.out.println("Error occurred while generating receipt: " + e.getMessage());
        }
    }

    private String formatReceiptContent() {
        StringBuilder sb = new StringBuilder();
        sb.append("Order Details:\n");
        sb.append(order.formatOrderDetails());

        return sb.toString();
    }

    private String generateFileName() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");
        String timestamp = now.format(formatter);
        return timestamp + ".txt";
    }
}
