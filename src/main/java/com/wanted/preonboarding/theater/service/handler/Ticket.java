package com.wanted.preonboarding.theater.service.handler;

import lombok.ToString;

@ToString
public class Ticket {
    private Long fee;

    public Ticket(Long fee) {
        this.fee = fee;
    }

    public Long getFee() {
        return fee;
    }
}
