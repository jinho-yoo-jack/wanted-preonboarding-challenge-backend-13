package com.wanted.preonboarding.theater.service.handler;

public class TicketSeller {
    private final TicketOffice ticketOffice;
    private Audience audience;

    public TicketSeller(TicketOffice ticketOffice){
        this.ticketOffice = ticketOffice;
    }

    public TicketOffice getTicketOffice(){
        return ticketOffice;
    }

    public void sellTicket(Audience audience) {
        getTicketOffice().plusAmount(audience.buyTicket(getTicketOffice().getTicket()));
    }
}
