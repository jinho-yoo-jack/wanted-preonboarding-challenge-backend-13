package com.wanted.preonboarding.theater.entity;

import lombok.Builder;
import lombok.Getter;

@Getter
public class Ticket {
    private Long fee;

    @Builder
    public Ticket(Long fee) {
        this.fee = fee;
    }

    public Long getFee() {
        return fee;
    }
}
