package com.wanted.preonboarding.theater.service.handler;
import com.wanted.preonboarding.theater.service.Interface.Pass;

public class Ticket implements Pass {
    private Long fee;

    public Ticket(Long fee) {
        this.fee = fee;
    }

    public Long getFee() {
        return fee;
    }
}
