package com.wanted.preonboarding.theater.entity;

import lombok.Getter;

@Getter
public class Ticket {
    private Long fee;

    public Ticket(Long fee) {
        this.fee = fee;
    }

    public Long getFee() {
        return fee;
    }
}
