package org.igire.week1_shecancode_iro.BankingTransactionProcessor.CustomExcepetionHierarchy;

// Base Checked Exception
public class TransactionException extends Exception {
    private final String errorCode;

    public TransactionException(String message, String errorCode) {
        super(message + " [Code: " + errorCode + "]");
        this.errorCode = errorCode;
    }

    public String getErrorCode() { return errorCode; }
}

