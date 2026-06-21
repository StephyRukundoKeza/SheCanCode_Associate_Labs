package org.igire.week1_shecancode_iro.BankingTransactionProcessor.ExceptionChaining_Logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import java.sql.SQLException;

public class AccountRepository {
    private static final Logger logger = LoggerFactory.getLogger(AccountRepository.class);

    public void getBalanceFromDb(String accountId, String txId) {
        MDC.put("transactionId", txId); // Attach transaction ID to all logs
        try {
            // Simulating a low-level DB failure
            throw new SQLException("Database connection timeout", "SQL-001");
        } catch (SQLException e) {
            // Log the high-level error while preserving the chain
            logger.error("Failed to retrieve balance for account: {}", accountId);
            throw new DataAccessException("Data access error occurred", e);
        } finally {
            MDC.remove("transactionId"); // Clean up thread context
        }
    }
}
