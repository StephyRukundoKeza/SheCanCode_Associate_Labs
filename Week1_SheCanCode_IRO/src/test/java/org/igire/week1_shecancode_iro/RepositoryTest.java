package org.igire.week1_shecancode_iro;

import org.igire.week1_shecancode_iro.BankingTransactionProcessor.ExceptionChaining_Logging.AccountRepository;
import org.igire.week1_shecancode_iro.BankingTransactionProcessor.ExceptionChaining_Logging.DataAccessException;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

public class RepositoryTest {

    @Test
    public void testExceptionChaining() {
        AccountRepository repo = new AccountRepository();

        // We expect a DataAccessException to be thrown
        DataAccessException ex = assertThrows(DataAccessException.class, () -> {
            repo.getBalanceFromDb("ACC1", "TXN-999");
        });

        // Verify the chain: The root cause must be the original SQLException
        assertNotNull(ex.getCause(), "The exception should have a cause");
        assertTrue(ex.getCause() instanceof SQLException, "Cause should be a SQLException");
        assertEquals("Database connection timeout", ex.getCause().getMessage());
    }
}
