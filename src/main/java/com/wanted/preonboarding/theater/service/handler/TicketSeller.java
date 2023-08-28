package com.wanted.preonboarding.theater.service.handler;

import org.springframework.stereotype.Component;

public class TicketSeller {
    private final TicketOffice ticketOffice;

    public TicketSeller(TicketOffice ticketOffice){
        this.ticketOffice = ticketOffice;
    }

    /**
     * ticket 판매 로직
     */
    public void sell(Audience audience) {
            ticketOffice.plusAmount(audience.buyTicket(ticketOffice.getTicket()));
    }
}
