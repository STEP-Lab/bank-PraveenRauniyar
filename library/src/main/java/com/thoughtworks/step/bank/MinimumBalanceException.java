package com.thoughtworks.step.bank;

public class MinimumBalanceException extends Throwable {
    public MinimumBalanceException() {
        super("Balance can not be less than 500");
    }
}
