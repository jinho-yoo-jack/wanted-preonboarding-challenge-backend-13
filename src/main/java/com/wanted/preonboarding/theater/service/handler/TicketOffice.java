package com.wanted.preonboarding.theater.service.handler;

import java.util.Arrays;
import java.util.List;

public class TicketOffice {
    private Long amount;
    private final List<Ticket> tickets;

    public TicketOffice(Long amount, Ticket ... tickets) {
        this.amount = amount;
        this.tickets = Arrays.asList(tickets);
    }

    public Ticket issueTicket() {
        return getTicket();
    }

    public void increaseSalesAmount(long ticketFee) {
        plusAmount(ticketFee);
    }

    private Ticket getTicket() {
        return tickets.get(0);
    }

    private void minusAmount(long amount) {
        this.amount -= amount;
    }
    private void plusAmount(long amount) {
        this.amount += amount;
    }
}
