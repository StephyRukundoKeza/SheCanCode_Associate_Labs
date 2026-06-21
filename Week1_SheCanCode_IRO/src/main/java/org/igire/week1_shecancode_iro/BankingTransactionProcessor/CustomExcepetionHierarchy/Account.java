package org.igire.week1_shecancode_iro.BankingTransactionProcessor.CustomExcepetionHierarchy;

public class Account {

    private String accountNumber;
    private double balance;

    public Account(String accountNumber, double initialbalance) {
        this.accountNumber = accountNumber;
        this.balance = initialbalance;
    }

    public double getBalance() {
        return balance;
    }

    public void withdraw(double amount) {
        this.balance -= amount;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }
}
