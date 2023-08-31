package com.wanted.preonboarding.theater.service.handler;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;

/**
 * 매표소 클래스
 */
public class TicketOffice {
    @Getter
    private long amount;
    private final List<Ticket> tickets;

    public TicketOffice(Long amount, Ticket ... tickets) {
        this.amount = amount;
        this.tickets = Arrays.asList(tickets);
    }

    public void minusAmount(long amount) {
        this.amount -= amount;
    }
    public void plusAmount(long amount) {
        this.amount += amount;
    }

    public Ticket getTicket(){
        return tickets.get(0);
    }
}
