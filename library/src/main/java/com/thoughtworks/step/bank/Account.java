package com.thoughtworks.step.bank;

import java.util.regex.Pattern;

public class Account{
    public final String accountNumber;
    public double balance;

    public Account(String accountNumber,double balance) throws MinimumBalanceException, AccountNumberException {
        if (!(Pattern.matches("\\d{4}-\\d{4}", accountNumber))){
            throw new AccountNumberException();
        }
        this.accountNumber = accountNumber;
        if(balance<500){
            throw new MinimumBalanceException();
        }

        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double debitAmount(double amount) throws MinimumBalanceException {
        if(this.balance - amount <500){
            throw new MinimumBalanceException();
        }
        this.balance -= amount;
        return this.balance;
    }

    public double creditAmount(double amount){
        this.balance += amount;
        return this.balance;

    }
}
