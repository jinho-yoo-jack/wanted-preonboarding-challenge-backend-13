package com.wanted.preonboarding.theater.domain;

import lombok.Builder;

import java.util.Arrays;
import java.util.List;

public class TicketOffice {
    private long sales;
    private final List<Ticket> tickets;
    private final TicketSeller ticketSeller = new TicketSeller();

    public TicketOffice(Long sales, Ticket ... tickets) {
        this.sales = sales;
        this.tickets = Arrays.asList(tickets);
    }

    public Ticket ticketIssue(Long amount) {
        Ticket ticket = ticketSeller.sendTo(tickets.get(0), amount);

        plusAmount(amount);

        return ticket;
    }

    public Ticket ticketIssue() {
        return ticketSeller.sendTo(tickets.get(0));
    }

    public void minusAmount(long amount) {
        this.sales -= amount;
    }
    public void plusAmount(long amount) {
        this.sales += amount;
    }
}
