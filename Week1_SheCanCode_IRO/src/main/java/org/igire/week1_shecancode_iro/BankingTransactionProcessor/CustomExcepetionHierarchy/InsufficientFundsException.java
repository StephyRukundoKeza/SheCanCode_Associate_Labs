package org.igire.week1_shecancode_iro.BankingTransactionProcessor.CustomExcepetionHierarchy;

// Specific Exception: Insufficient Funds
public class InsufficientFundsException extends TransactionException {
    public InsufficientFundsException(String message, String errorCode) {
        super(message, errorCode);
    }
}
