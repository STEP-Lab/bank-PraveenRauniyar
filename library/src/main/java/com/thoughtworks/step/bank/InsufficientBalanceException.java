package com.thoughtworks.step.bank;

public class InsufficientBalanceException extends Throwable {
    public InsufficientBalanceException() {
        super("Balance can not be less than 500");
    }
}
