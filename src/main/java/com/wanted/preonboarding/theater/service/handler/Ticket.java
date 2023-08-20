package com.wanted.preonboarding.theater.service.handler;

import lombok.Getter;

// 티켓 클래스
@Getter
public class Ticket {
    private final Long fee;

    public Ticket(final Long fee) {
        this.fee = fee;
    }
}
