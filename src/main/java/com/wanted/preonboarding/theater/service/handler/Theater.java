package com.wanted.preonboarding.theater.service.handler;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Theater {

    private final TicketSeller ticketSeller =  new TicketSeller(new TicketOffice(20000L, new Ticket(100L)));
    public void enter(Audience audience){
        ticketSeller.sellTicket(audience);
    }
}
