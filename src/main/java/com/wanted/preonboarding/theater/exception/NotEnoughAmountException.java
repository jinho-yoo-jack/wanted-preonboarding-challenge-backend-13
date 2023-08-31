package com.wanted.preonboarding.theater.exception;

public class NotEnoughAmountException extends RuntimeException {
    public NotEnoughAmountException() {
        super("NotEnoughAmountException");
    }

    public NotEnoughAmountException(String msg) {
        super(msg);
    }
}
