package com.thoughtworks.step.bank;

import org.junit.Test;

import java.util.Date;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class AccountNumberTest {
    @Test
    public void checkAccountNumber() throws AccountNumberException {
        AccountNumber accountNumber = new AccountNumber("1234-6758");
    }

    @Test(expected = AccountNumberException.class)
    public void accountNumberException() throws AccountNumberException {
        AccountNumber accountNumber = new AccountNumber("123-567");
    }

    @Test(expected = AccountNumberException.class)
    public void accountNumberExceptionWithCharacter() throws AccountNumberException {
        AccountNumber accountNumber = new AccountNumber("1abh-5678");
    }

    public static class TransactionTest {
        @Test
        public void mustAddTransaction()  {
            Date date = new Date();
            Transaction transaction =  new Transaction(date,2000,"to",4000);
            assertThat(transaction.getDate(),is(date));
        }
    }
}
