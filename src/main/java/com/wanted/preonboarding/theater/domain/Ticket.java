package com.wanted.preonboarding.theater.domain;

import lombok.Getter;

@Getter
public class Ticket {
    private final Long fee;
    private boolean isCheck = false;

    public Ticket(Long fee) {
        this.fee = fee;
    }

    public void checkTicket() {
        this.isCheck = true;
    }
}
