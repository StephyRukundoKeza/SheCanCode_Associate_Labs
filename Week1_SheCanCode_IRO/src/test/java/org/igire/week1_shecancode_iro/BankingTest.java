package org.igire.week1_shecancode_iro;

import org.igire.week1_shecancode_iro.BankingTransactionProcessor.CustomExcepetionHierarchy.*;
import org.junit.jupiter.api.Test;

public class BankingTest {
    BankingTransactionProcessor processor = new BankingTransactionProcessor();

    Account acc1 =new Account("ACC001", 5000);
    Account acc2 =new Account("ACC002", 200);

    @Test
    public void processMyTransfer() {
        //BankingTransactionProcessor processor = new BankingTransactionProcessor();

        try {
            processor.transfer(acc1, acc2, 500.0);
            System.out.printf("Transfer successful! Balance 1: %.2f, Balance 2: %.2f%n",
                    acc1.getBalance(), acc2.getBalance());
        } catch ( InsufficientFundsException | FraudDetectedException e) {
            // Handle specific business logic
            System.err.println("Transaction Failed: " + e.getMessage());
        } catch (TransactionException e) {
            // Catch-all for any other transaction-related issues
            System.err.println("Generic Transaction Error: " + e.getErrorCode());
        }
    }
}
