package org.igire.week1_shecancode_iro.BankingTransactionProcessor.ResourceManagement;

import java.io.*;
import java.util.*;

public class TransactionProcessor {

    public void processTransactions(String filePath) {
        List<String> errors = new ArrayList<>();
        int processedCount = 0;

        // Try-with-resources automatically closes the reader
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                try {
                    parseLine(line); // Logic to process/validate
                    processedCount++;
                } catch (Exception e) {
                    errors.add("Line: " + line + " | Error: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.err.println("Critical file error: " + e.getMessage());
        }

        // Summary Report
        System.out.printf("Processed: %d, Failed: %d%n", processedCount, errors.size());

        // Write failures to a separate file
        if (!errors.isEmpty()) {
            try (PrintWriter writer = new PrintWriter("failed_transactions.txt")) {
                errors.forEach(writer::println);
            } catch (IOException e) {
                System.err.println("Could not write error file: " + e.getMessage());
            }
        }
    }

    private void parseLine(String line) throws Exception {
        // Validation logic here
        if (line.isEmpty() || !line.contains(",")) {
            throw new Exception("Malformed transaction format");
        }
    }
}
