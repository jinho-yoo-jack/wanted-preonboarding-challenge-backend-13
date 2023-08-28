package com.wanted.preonboarding.theater.service.handler;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Theater {

    public String enter(Audience audience, Ticket ticket) {
        TicketSeller ticketseller = new TicketSeller(new TicketOffice(20000L, ticket));

        if (audience.hasTicket()) {
            return "The ticket has been verified.";
        } else if (audience.hasInvitation()) {
            ticketseller.convertInvitationToTicket(audience);
            return "The invitation has been converted into a ticket.";
        } else {
            ticketseller.sellTicket(audience);
            return "The ticket has been purchased.";
        }
    }
}
