package org.example;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Receipt {

    private static final String RECEIPTS_FOLDER = "receipts/";

    public static void saveReceipt(Order order) {
        String fileName = generateFileName();
        String receiptContent = generateReceiptContent(order);

        try (FileWriter fileWriter = new FileWriter(RECEIPTS_FOLDER + fileName)) {
            fileWriter.write(receiptContent);
            System.out.println("Receipt saved successfully: " + fileName);
        } catch (IOException e) {
            System.out.println("Failed to save receipt.");
            e.printStackTrace();
        }
    }

    private static String generateFileName() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");
        return now.format(formatter) + ".txt";
    }

    private static String generateReceiptContent(Order order) {
        StringBuilder receipt = new StringBuilder();
        receipt.append("Order Details:\n");
        receipt.append(order.getReceipt());
        receipt.append("Total Price: $").append(order.getTotalPrice()).append("\n");
        return receipt.toString();
    }
}
