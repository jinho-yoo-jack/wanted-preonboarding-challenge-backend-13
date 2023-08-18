package com.wanted.preonboarding.theater.domain;

import java.util.Arrays;
import java.util.List;

public class TicketOffice {
    private long amount;
    private final List<Ticket> tickets;

    public TicketOffice(Long amount, Ticket ... tickets) {
        this.amount = amount;
        this.tickets = Arrays.asList(tickets);
    }

    public Ticket getTicket(){
        return tickets.get(0);
    }
    public void plusAmount(long amount) {
        this.amount += amount;
    }
}
