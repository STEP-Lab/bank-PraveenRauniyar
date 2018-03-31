package com.thoughtworks.step.bank;

import org.junit.Test;

import java.util.Date;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CreditTransactionTest {
    @Test
    public void dateMustRecordToTransaction() {
        Date date = new Date();
        Transaction creditTransaction = new CreditTransaction(2000,"manish",5000);
        assertThat(creditTransaction.getDate(),is(date));
    }
}