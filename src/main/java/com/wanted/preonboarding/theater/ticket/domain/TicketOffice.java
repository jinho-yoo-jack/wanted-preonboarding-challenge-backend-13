package com.wanted.preonboarding.theater.ticket.domain;

import java.util.Arrays;
import java.util.List;

public class TicketOffice {
    private final List<Ticket> tickets;
    private volatile long amount;

    public TicketOffice(Long amount, Ticket... tickets) {
        this.amount = amount;
        this.tickets = Arrays.asList(tickets);
    }

    public Ticket getTicket() {
        return tickets.get(0);
    }

    public synchronized void plusAmount(long amount) {
        this.amount += amount;
    }
}
