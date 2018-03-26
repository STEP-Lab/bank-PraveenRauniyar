package com.thoughtworks.step.bank;

import org.junit.Test;

import java.util.Date;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class DebitTransactionTest {
    @Test
    public void dateMustRecordToTransaction() {
        Date date = new Date();
        Transaction transaction = new DebitTransaction(date,2000,"manish");
        assertThat(transaction.getDate(),is(date));
    }
}
