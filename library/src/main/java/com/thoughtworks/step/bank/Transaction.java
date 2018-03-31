package com.thoughtworks.step.bank;

import java.util.Date;
import java.util.Objects;

public class Transaction {
    private final Date date;
    private final double amount;
    private String to;
    private final double currentBalance;


    public Transaction(Date date, double amount, String to,double currentBalance) {
        this.date = date;
        this.amount = amount;
        this.to = to;
        this.currentBalance = currentBalance;
    }
    public Date getDate(){
        return date;
    }
    public double getAmount(){
        return amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return Double.compare(that.amount, amount) == 0 &&
                Objects.equals(to, that.to);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, to);
    }

    @Override
    public String toString() {
        return
                date +","+
                + amount +","+
                ","+ to + '\'';
    }
}
// java.util.currency.data.