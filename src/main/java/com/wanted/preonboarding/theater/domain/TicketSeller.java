package com.wanted.preonboarding.theater.domain;

public class TicketSeller {

    public Ticket sendTo(Ticket ticket, Long amount) {
        if (!amount.equals(ticket.getFee())) {
            throw new IllegalArgumentException();
        }
        return ticket;
    }

    public Ticket sendTo(Ticket ticket) {
        return ticket;
    }
}
