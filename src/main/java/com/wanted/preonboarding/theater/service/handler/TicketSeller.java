package com.wanted.preonboarding.theater.service.handler;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TicketSeller {

    private final TicketOffice ticketOffice;

    public TicketOffice getTicketOffice(){
        return ticketOffice;
    }

    public void sellTicket(Audience audience) {
        ticketOffice.plusAmount(audience.buy(ticketOffice.getTicket()));
    }

}
