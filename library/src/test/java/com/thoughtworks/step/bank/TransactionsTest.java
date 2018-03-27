package com.thoughtworks.step.bank;

import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.core.IsCollectionContaining.hasItems;
import static org.junit.Assert.assertThat;

public class TransactionsTest {

    private Transactions transactions;

    @Before
    public void setUp() {
        transactions = new Transactions();
    }

    @Test
    public void mustRecordCreditTransaction() {
        transactions.credit(2000,"hey");
        assertThat(transactions.allTransactions,hasItem(new CreditTransaction(new Date(),2000,"hey")));
    }

    @Test
    public void mustRecordDebitTransaction() {
        transactions.debit(3000,"ashish");
        assertThat(transactions.allTransactions, hasItem(new DebitTransaction(new Date(),3000,"ashish")));
    }

    @Test
    public void mustRecordsDebitAndCredit() {
        transactions.debit(3000,"ashish");
        transactions.credit(2000,"hey");
        assertThat(transactions.allTransactions,hasItems(new DebitTransaction(new Date(),3000,"ashish"),new CreditTransaction(new Date(),2000,"hey")));
    }

    @Test
    public void getAllTransactionAboveSpecificLimit() {
        transactions.debit(3000,"ashish");
        transactions.debit(500,"hey");
        transactions.credit(1000,"hoy");
        DebitTransaction ashish = new DebitTransaction(new Date(),3000,"ashish");
        Transaction hey = new CreditTransaction(new Date(),1000,"hoy");
        assertThat(transactions.getAllTransactionAboveSpecificLimit(600),hasItems(ashish,hey));
    }

    @Test
    public void getAllTransactionBelowSpecificLimit() {
        transactions.debit(3000,"ashish");
        transactions.debit(500,"hey");
        transactions.credit(1000,"hoy");
        DebitTransaction hey = new DebitTransaction(new Date(),500,"hey");
        assertThat(transactions.getAllTransactionBelowSpecificLimit(600),hasItems(hey));
    }
}
