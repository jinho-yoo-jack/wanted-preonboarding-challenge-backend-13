package com.wanted.preonboarding.theater.service.handler;

public class Ticket {

    private final Long fee;

    public Ticket(Long fee) {
        this.fee = fee;
    }

    public Long getFee() {
        return fee;
    }
}
