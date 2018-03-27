package com.thoughtworks.step.bank;

import java.util.ArrayList;

public class Transactions {

    protected final ArrayList<Transaction> allTransactions;

    public Transactions() {
        this.allTransactions = new ArrayList<>();
    }
    public void credit(double amount,String to){
        allTransactions.add(new CreditTransaction(amount,to));

    }
    public void debit(double amount,String to){
        allTransactions.add(new DebitTransaction(amount,to));
    }


    public ArrayList<Transaction> getAllTransactionAboveSpecificLimit(int amount) {
        Transactions transactions = new Transactions();
        for (Transaction transaction:allTransactions){
            if(transaction.getAmount()>amount){
                transactions.allTransactions.add(transaction);

            }
        }
        return transactions.allTransactions;
    }

    public ArrayList<Transaction> getAllTransactionBelowSpecificLimit(int amount) {
        Transactions transactions = new Transactions();
        for (Transaction transaction:allTransactions){
            if(transaction.getAmount()<amount){
                transactions.allTransactions.add(transaction);

            }
        }
        return transactions.allTransactions;
    }
}
