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
        transactions.credit(2000,"hey",3000);
        CreditTransaction creditTransaction = new CreditTransaction(new Date(),2000,"hey",3000);
        assertThat(transactions.allTransactions,hasItem(creditTransaction));
    }

    @Test
    public void mustRecordDebitTransaction() {
        transactions.debit(3000,"ashish",3000);
        DebitTransaction debitTransaction = new DebitTransaction(new Date(),3000,"ashish",3000);
        assertThat(transactions.allTransactions, hasItem(debitTransaction));
    }

    @Test
    public void mustRecordsDebitAndCredit() {
        transactions.debit(3000,"ashish",3000);
        transactions.debit(3000,"ashish",3000);
        transactions.credit(2000,"hey",3000);
        CreditTransaction hey = new CreditTransaction(new Date(),2000,"hey",3000);
        DebitTransaction ashish = new DebitTransaction(new Date(),3000,"ashish",3000);
        assertThat(transactions.allTransactions,hasItems(ashish,hey));
    }

    @Test
    public void getAllTransactionAboveSpecificLimit() {
        transactions.debit(3000,"ashish",3000);
        transactions.debit(500,"hey",3000);
        transactions.credit(1000,"hoy",3000);
        DebitTransaction ashish = new DebitTransaction(new Date(),3000,"ashish",3000);
        Transaction hey = new CreditTransaction(new Date(),1000,"hoy",3000);
        assertThat(transactions.getAllTransactionAboveSpecificLimit(600).allTransactions,hasItems(ashish,hey));
    }

    @Test
    public void getAllTransactionBelowSpecificLimit() {
        transactions.debit(3000,"ashish",3000);
        transactions.debit(500,"hey",3000);
        transactions.credit(1000,"hoy",3000);
        DebitTransaction hey = new DebitTransaction(new Date(),500,"hey",3000);
        assertThat(transactions.getAllTransactionBelowSpecificLimit(600).allTransactions,hasItems(hey));
    }

    @Test
    public void getAllDebitTransaction() {
        transactions.debit(3000,"ashish",3000);
        transactions.credit(1000,"hoy",3000);
        transactions.debit(500,"hey",3000);
        Transaction ashish = new DebitTransaction(new Date(),3000,"ashish",3000);
        Transaction hey = new DebitTransaction(new Date(),500,"hey",3000);
        assertThat(transactions.getAllDebitTransaction().allTransactions,hasItems(ashish,hey));
    }

    @Test
    public void getAllCreditTransaction() {
        transactions.debit(3000,"ashish",3000);
        transactions.credit(500,"hey",3000);
        Transaction ashish = new DebitTransaction(new Date(),3000,"ashish",3000);
        Transaction hey = new CreditTransaction(new Date(),500,"hey",3000);
        assertThat(transactions.getAllCreditTransaction().allTransactions,hasItems(hey));
    }

    @Test
    public void getAllTransactionsBeforeSpecificDate() {
        transactions.debit(3000,"ashish",3000);
        transactions.credit(4000,"abhishek",3000);
        Date date = new Date(2019,10,12);
        Transaction ashish = new DebitTransaction(new Date(),3000,"ashish",3000);
        Transaction abhishek = new CreditTransaction(new Date(),4000,"abhishek",3000);
        assertThat(transactions.getAllTransactionsBeforeSpecificDate(date).allTransactions,hasItems(ashish,abhishek));
    }

    @Test
    public void getAllTransactionAfterSpecificDate() {
        transactions.debit(1200,"ashish",3000);
        transactions.credit(1700,"abhishek",3000);
        Calendar cal = Calendar.getInstance();
        cal.set(2018, Calendar.JANUARY, 9);
        Date date = cal.getTime();
        Transaction ashish = new DebitTransaction(new Date(),1200,"ashish",3000);
        Transaction abhishek = new CreditTransaction(new Date(),1700,"abhishek",3000);
        assertThat(transactions.getAllTransactionsAfterSpecificDate(date).allTransactions,hasItems(abhishek,ashish));
    }

//    @Test
//    public void threadTest() {
//        Thread thread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                transactions.debit(1200,"ashish",3000);
//                transactions.credit(1700,"abhishek",3000);
//            }
//        });
//        Thread thread2 = new Thread(new Runnable(){
//            @Override
//            public void run() {
//                transactions.debit(1100,"ashish",3000);
//            }
//        });
//        thread.run();
//        thread2.run();
//    }
}
