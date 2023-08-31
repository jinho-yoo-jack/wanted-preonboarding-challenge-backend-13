package com.wanted.preonboarding.theater.service.handler;

import java.util.Arrays;
import java.util.List;

public class TicketOffice {
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

    public Ticket giveTicket() {
        return tickets.get(0);
    }

    public long getAmount() {
        return this.amount;
    }

    public Ticket sellTicket() {
        Ticket ticket = giveTicket();
        plusAmount(ticket.getFee());
        return ticket;
    }
}
