package com.thoughtworks.step.bank;

public class AccountNumberException extends Throwable {
    public AccountNumberException() {
        super("Account number should be 4digit-4digit pattern");
    }
}
