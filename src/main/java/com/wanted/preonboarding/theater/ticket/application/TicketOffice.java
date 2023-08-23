package com.wanted.preonboarding.theater.ticket.application;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class TicketOffice {
    private static final String TICKET_NOT_FOUND = "티켓이 존재하지 않습니다.";
    private static final Long TICKET_OFFICE_INIT_MONEY = 20_000L;

    private volatile long amount;

    @PostConstruct
    public void init() {
        this.amount = TICKET_OFFICE_INIT_MONEY;
    }

    public synchronized void chargeAmount(long amount) {
        this.amount += amount;
    }

    public long getAmount() {
        return this.amount;
    }
}
