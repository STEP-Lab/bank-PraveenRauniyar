package com.thoughtworks.step.bank;

import java.util.Date;

public class DebitTransaction extends Transaction {
    protected DebitTransaction(Date date, double amount, String to,double currentBalance) {
        super(date, amount, to,currentBalance);
    }

    public DebitTransaction(double amount, String to,double currentBalance) {
        this(new Date(),amount,to,currentBalance);
    }
}
