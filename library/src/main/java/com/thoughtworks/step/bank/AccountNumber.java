package com.thoughtworks.step.bank;

import java.util.regex.Pattern;

public class AccountNumber {
    private String accountNumber;

    public AccountNumber(String accountNumber) throws AccountNumberException {
        verifyAccountNumber(accountNumber);
    }

    public void verifyAccountNumber(String accountNumber) throws AccountNumberException {
        if (!(Pattern.matches("\\d{4}-\\d{4}", accountNumber))){
            throw new AccountNumberException();
        }
    }

}

