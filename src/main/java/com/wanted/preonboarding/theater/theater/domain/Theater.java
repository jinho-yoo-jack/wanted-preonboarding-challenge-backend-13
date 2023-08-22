package com.wanted.preonboarding.theater.theater.domain;

import com.wanted.preonboarding.theater.audience.domain.Audience;
import com.wanted.preonboarding.theater.audience.domain.Bag;
import com.wanted.preonboarding.theater.ticket.application.TicketSeller;
import com.wanted.preonboarding.theater.ticket.domain.Ticket;

public class Theater {
    private final Audience audience;
    private final TicketSeller ticketSeller;
    public Theater(Audience audience, Ticket ticket, TicketSeller ticketSeller) {
        this.audience = audience;
        this.ticketSeller = ticketSeller;
    }

    public void enter() {
        Bag bag = audience.getBag();

        if (bag.hasInvitation()) {
            ticketSeller.getTicket()
        }
    }
}
