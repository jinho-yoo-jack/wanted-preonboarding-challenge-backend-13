package com.wanted.preonboarding.theater.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Theater {
    private final TicketSeller ticketSeller;

    public void enter(Audience audience, TicketSeller ticketSeller){
        if (audience.hasTicket()) {
            return;
        }

        if (audience.hasInvitation()) {
            Ticket ticket = ticketSeller.changeTicket();
            audience.changeTicket(ticket);
            return;
        }

        if (!audience.hasTicket()) {
            Ticket ticket = ticketSeller.sellTo(audience.myMoney());
            audience.buyTiket(ticket);
        }

    }
}
