package com.wanted.preonboarding.theater.service.handler;

import org.springframework.stereotype.Component;

@Component
public class TicketSeller {
    private final TicketOffice ticketOffice;

    public TicketSeller(TicketOffice ticketOffice) {
        this.ticketOffice = ticketOffice;
    }

    public boolean sellTicketTo(Audience audience){
        return ticketOffice.sellTicketTo(audience);
    }

    public Ticket changeInvitiactionByTicket(Audience audience) {
        return ticketOffice.changeInvitiactionByTicket(audience);
    }

}
