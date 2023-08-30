package com.wanted.preonboarding.theater.service.handler;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Theater {

    private TicketSeller ticketSeller;
    public void enter(Audience audience){
        TicketSeller ticketSeller = new TicketSeller(new TicketOffice(20000L, new Ticket(100L)));
        ticketSeller.sellTicket(audience);
    }
}
