package com.thoughtworks.step.bank;

public class Account{
    public final AccountNumber accountNumber;
    public double balance;

    public Account(AccountNumber accountNumber, double balance) throws InsufficientBalanceException, AccountNumberException {
        this.accountNumber = accountNumber;
        checkMinimumBalance(balance);
        this.balance = balance;
    }

   public void checkMinimumBalance(double balance) throws InsufficientBalanceException {
        if(balance <500){
            throw new InsufficientBalanceException();
        }
    }

    public double getBalance() {
        return balance;
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
