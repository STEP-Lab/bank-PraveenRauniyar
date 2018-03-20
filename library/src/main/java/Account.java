package com.thougtworks.step.bank;
public class Account{
    public final String accountNumber;
    public double balance;

    public Account(String accountNumber,double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double debitAmount(double amount){
        this.balance -= amount;
        return this.balance;
    }

    public double creditAmount(double amount) {
        this.balance += amount;
        return this.balance;

    }
//    (Pattern.matches("\\d{4}-\\d{4}", "1234-6887");
}
