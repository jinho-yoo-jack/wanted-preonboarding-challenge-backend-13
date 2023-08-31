package com.wanted.preonboarding.theater.service.handler;

public class Ticket {
    private final Money fee;

    public Ticket(Long money) {
        this.fee = new Money(money);
    }

    public Money getFee() {
        return fee;
    }
}
