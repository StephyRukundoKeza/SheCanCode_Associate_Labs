package org.igire.week1_shecancode_iro.BankingTransactionProcessor.CustomExcepetionHierarchy;

// Specific Exception: Fraud
public class FraudDetectedException extends TransactionException {
    public FraudDetectedException(String message, String errorCode) {
        super(message, errorCode);
    }
}
