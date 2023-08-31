package com.wanted.preonboarding.theater.service.handler;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;

@Getter
public class TicketOffice {
    private long amount;
    private final List<Ticket> tickets;

    public TicketOffice(Long amount, Ticket ... tickets) {
        this.amount = amount;
        this.tickets = Arrays.asList(tickets);
    }

    public TicketOffice() {
        this.amount = 10000L;
        this.tickets = Arrays.asList(new Ticket(100L));
    }

    public Ticket getTicket(){
        return tickets.get(0);
    }

    public void minusAmount(long amount) {
        this.amount -= amount;
    }
    public void plusAmount(long amount) {
        this.amount += amount;
    }
}
