package com.thoughtworks.step.bank;

import java.util.ArrayList;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transactions that = (Transactions) o;
        return Objects.equals(allTransactions, that.allTransactions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(allTransactions);
    }
}
