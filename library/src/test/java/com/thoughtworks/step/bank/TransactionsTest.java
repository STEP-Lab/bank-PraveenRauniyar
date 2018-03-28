package com.thoughtworks.step.bank;

import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;
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

    @Test
    public void getAllDebitTransaction() {
        transactions.debit(3000,"ashish");
        transactions.credit(1000,"hoy");
        transactions.debit(500,"hey");
        Transaction ashish = new DebitTransaction(new Date(),3000,"ashish");
        Transaction hey = new DebitTransaction(new Date(),500,"hey");
        assertThat(transactions.getAllDebitTransaction(),hasItems(ashish,hey));
    }

    @Test
    public void getAllTransactionsBeforeSpecificDate() {
        transactions.debit(3000,"ashish");
        transactions.credit(4000,"abhishek");
        Date date = new Date(2019,10,12);
        Transaction ashish = new DebitTransaction(new Date(),3000,"ashish");
        Transaction abhishek = new CreditTransaction(new Date(),4000,"abhishek");
        assertThat(transactions.getAllTransactionsBeforeSpecificDate(date),hasItems(ashish,abhishek));
    }

    @Test
    public void getAllTransactionAfterSpecificDate() {
        transactions.debit(1200,"ashish");
        transactions.credit(1700,"abhishek");
        Calendar cal = Calendar.getInstance();
        cal.set(2018, Calendar.JANUARY, 9);
        Date date = cal.getTime();
        Transaction ashish = new DebitTransaction(new Date(),1200,"ashish");
        Transaction abhishek = new CreditTransaction(new Date(),1700,"abhishek");
        assertThat(transactions.getAllTransactionsAfterSpecificDate(date),hasItems(abhishek,ashish));
    }
}
