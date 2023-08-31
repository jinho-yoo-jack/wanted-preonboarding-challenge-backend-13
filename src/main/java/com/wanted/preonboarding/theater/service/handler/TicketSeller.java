package com.wanted.preonboarding.theater.service.handler;

public class TicketSeller {
    private final TicketOffice ticketOffice;

    public TicketSeller(TicketOffice ticketOffice){
        this.ticketOffice = ticketOffice;
    }

    public TicketOffice getTicketOffice(){
        return ticketOffice;
    }

    public void sell(Audience audience) {
        long ticketFee = audience.buy(ticketOffice.getTicket());
        ticketOffice.plusAmount(ticketFee);
    }
}
