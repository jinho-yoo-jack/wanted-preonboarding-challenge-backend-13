package com.wanted.preonboarding.theater.service.handler;

import org.springframework.stereotype.Component;

@Component
public class Theater {

    private final TicketSeller ticketSeller =
            new TicketSeller(new TicketOffice(20000L, new Ticket(100L)));

    public void enter(Audience audience){
        ticketSeller.sellTo(audience);
    }
}
