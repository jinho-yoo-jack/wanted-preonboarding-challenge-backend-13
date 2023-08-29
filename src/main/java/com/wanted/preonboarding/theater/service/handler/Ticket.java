package com.wanted.preonboarding.theater.service.handler;

import org.springframework.stereotype.Component;

@Component
public class Ticket {
    private Long fee;
    private Long amount;

    public Ticket(){}
    public Ticket(Long fee) {
        this.fee = fee;
    }


    public Long getFee() {
        return fee;
    }
}