package com.thoughtworks.step.bank;

import java.util.ArrayList;
import java.util.Date;

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

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Transactions that = (Transactions) o;
//        return Objects.equals(allTransactions, that.allTransactions);
//    }
//
//    @Override
//    public int hashCode() {
//
//        return Objects.hash(allTransactions);
//    }

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

    public ArrayList<Transaction> getAllDebitTransaction() {
        Transactions transactions = new Transactions();
        for (Transaction transaction:allTransactions){
            if (transaction instanceof DebitTransaction){
                transactions.allTransactions.add(transaction);
            }
        }
        return transactions.allTransactions;
    }

    public ArrayList<Transaction> getAllTransactionsBeforeSpecificDate(Date date) {
        Transactions transactions = new Transactions();
        for (Transaction transaction:allTransactions){
            if (transaction.getDate().before(date)){
                transactions.allTransactions.add(transaction);
            }
        }
        return transactions.allTransactions;
    }

    public ArrayList<Transaction> getAllTransactionsAfterSpecificDate(Date date) {
        Transactions transactions = new Transactions();
        for (Transaction transaction : allTransactions){
            if (transaction.getDate().after(date)) {
                transactions.allTransactions.add(transaction);
            }
        }
        return transactions.allTransactions;
    }
}
