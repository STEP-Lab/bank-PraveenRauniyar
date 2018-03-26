package com.thoughtworks.step.bank;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class AccountTest {
    private Account account;
    private AccountNumber accountNumber;

    @Before
    public void setup() throws InsufficientBalanceException, AccountNumberException {
        account = new Account(new AccountNumber("1234-2345"),1500);
    }

    @Test
    public void checkBalance() {
        assertThat(account.getBalance(),is(1500.0));
    }

    @Test
    public void debitAmount() throws InsufficientBalanceException {
        assertThat( account.debitAmount(200),is(1300.0));
    }

    @Test(expected = InsufficientBalanceException.class)
    public void minimumBalanceExceptionWithDebit() throws InsufficientBalanceException {
        assertThat( account.getBalance(),is(1500.0));
        account.debitAmount(1200);
    }

    @Test
    public void creditAmount() {
        assertThat(account.creditAmount(200),is(1700.0));
    }

    @Test(expected = InsufficientBalanceException.class)
    public void checkMinimumBalance() throws InsufficientBalanceException, AccountNumberException {
        Account account = new Account(new AccountNumber("1234-5678"), 100);
    }
}

