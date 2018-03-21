package com.thoughtworks.step.bank;

import java.util.regex.Pattern;

public class Account{
    public final String accountNumber;
    public double balance;

    public Account(String accountNumber,double balance) throws InsufficientBalanceException, AccountNumberException {
        checkAccountNumber(accountNumber);
        this.accountNumber = accountNumber;
        checkMinimumBalance(balance);
        this.balance = balance;
    }

    public void checkAccountNumber(String accountNumber) throws AccountNumberException {
        if (!(Pattern.matches("\\d{4}-\\d{4}", accountNumber))){
            throw new AccountNumberException();
        }
    }

   public void checkMinimumBalance(double balance) throws InsufficientBalanceException {
        if(balance <500){
            throw new InsufficientBalanceException();
        }
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double debitAmount(double amount) throws InsufficientBalanceException {
        checkMinimumBalance(this.balance - amount);
        this.balance -= amount;
        return this.balance;
    }

    public double creditAmount(double amount){
        this.balance += amount;
        return this.balance;
    }
}
