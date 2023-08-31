package com.wanted.preonboarding.theater.service.handler;

import lombok.Getter;

@Getter
public class Ticket {
    private Long fee;

    public Ticket(Long fee) {
        this.fee = fee;
    }
}
