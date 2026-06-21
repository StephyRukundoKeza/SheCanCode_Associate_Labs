package org.igire.week1_shecancode_iro.BankingTransactionProcessor.ExceptionChaining_Logging;

public class DataAccessException extends RuntimeException {
    public DataAccessException(String message, Throwable cause) {

        super(message, cause);
    }
}
