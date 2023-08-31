package com.wanted.preonboarding.theater.service.handler;

import jakarta.annotation.Nonnull;

public final class Ticket {

    private final Long fee;

    private Ticket(Long fee) {
        this.fee = fee;
    }

    public static Ticket create(@Nonnull Long fee) {
        return new Ticket(fee);
    }

    public Long getFee() {
        return fee;
    }
}
