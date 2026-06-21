package org.igire.week1_shecancode_iro.BankingTransactionProcessor.CustomExcepetionHierarchy;

public class BankingTransactionProcessor {

    public void transfer(Account from, Account to, double amount)
            throws InsufficientFundsException, FraudDetectedException {


        if (amount > 10000) {
            throw new FraudDetectedException("Transaction flagged for review.", "ERR_FRAUD_01");
        }


        if (from.getBalance() < amount) {
            throw new InsufficientFundsException("Account balance too low.", "ERR_FUNDS_02");
        }


        from.withdraw(amount);
        to.deposit(amount);
    }
}
