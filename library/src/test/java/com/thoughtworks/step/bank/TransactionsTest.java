package com.thoughtworks.step.bank;

import org.junit.Test;

import java.util.Date;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.junit.Assert.assertThat;

public class TransactionsTest {
    @Test
    public void mustRecordCreditTransaction() {
        Transactions transactions = new Transactions();
        transactions.credit(2000,"hey");
        assertThat(transactions.allTransactions,hasItem(new CreditTransaction(new Date(),2000,"hey")));
    }

    @Test
    public void mustRecordDebitTransaction() {
        Transactions transactions = new Transactions();
        transactions.debit(3000,"ashish");
        assertThat(transactions.allTransactions, hasItem(new DebitTransaction(new Date(),3000,"ashish")));
    }
}
