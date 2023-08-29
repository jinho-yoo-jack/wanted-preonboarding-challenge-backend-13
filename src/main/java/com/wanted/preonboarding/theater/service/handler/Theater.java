package com.wanted.preonboarding.theater.service.handler;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Theater {

    public void enter(Audience audience, TicketSeller ticketSeller){
        Ticket ticket = ticketSeller.getTicketOffice().getTicket();
        if (audience.buyTicket(ticket)) {
            ticketSeller.getTicketOffice().plusAmount(ticket.getFee());
        }
    }
}
