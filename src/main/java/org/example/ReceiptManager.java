package org.example;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReceiptManager {

    private String folderPath;

    public ReceiptManager(String folderPath) {
        this.folderPath = folderPath;
    }

    public void createReceipt(String receiptContent) {
        String fileName = generateFileName();
        String filePath = folderPath + File.separator + fileName;

        try {
            FileWriter writer = new FileWriter(filePath);
            writer.write(receiptContent);
            writer.close();

            // Write the receipt to the file
            FileWriter fileWriter = new FileWriter(filePath);
            fileWriter.write(receiptContent);
            fileWriter.close();
            System.out.println("Receipt created: " + fileName);
        } catch (IOException e) {
            System.out.println("Error creating receipt: " + fileName);
        }
    }


    private String generateFileName() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd-hhmmss");
        String timestamp = now.format(formatter);
        return "receipt-" + timestamp + ".txt";
    }

}