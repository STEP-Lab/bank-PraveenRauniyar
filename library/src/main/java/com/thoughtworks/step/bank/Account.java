package com.thoughtworks.step.bank;

public class Account{
    private final AccountNumber accountNumber;
    private double balance;
    private Transactions transactions = new Transactions();

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

    public double debitAmount(double amount,String source) throws InsufficientBalanceException {
        checkMinimumBalance(this.balance - amount);
        this.balance -= amount;
        transactions.debit(amount,source,this.balance);
        return this.balance;
    }

    public double creditAmount(double amount,String source){
        this.balance += amount;
        transactions.credit(amount,source,this.balance);
        return this.balance;
    }
}
