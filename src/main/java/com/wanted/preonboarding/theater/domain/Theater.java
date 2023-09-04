package com.wanted.preonboarding.theater.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Theater {

    public void enter(Audience audience, TicketSeller ticketSeller) {
        if (audience.hasInvitation()) {
            giveTicket(audience, ticketSeller.getTicket());
        } else {
            sellTicket(audience, ticketSeller);
        }
    }

    private void sellTicket(Audience audience, TicketSeller ticketSeller) {
        Ticket sellingTicket = ticketSeller.getTicket(audience);
        audience.buyTicket(sellingTicket);
        ticketSeller.sellTicket(sellingTicket);
    }

    private void giveTicket(Audience audience, Ticket ticket) {
        audience.takeTicket(ticket);
    }
}
