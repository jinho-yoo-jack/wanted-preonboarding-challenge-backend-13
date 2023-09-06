package com.wanted.preonboarding.theater.service.handler;

public class TicketSeller {
    private final TicketOffice ticketOffice;

    public TicketSeller(TicketOffice ticketOffice){
        this.ticketOffice = ticketOffice;
    }

    public void giveTo(Audience audience) {
        Ticket ticket = ticketOffice.getTicket();
        audience.holdTicket(ticket);
    }

    public void sellTo(Audience audience) {
        Ticket ticket = ticketOffice.getTicket();
        charge(audience, ticket);
        audience.holdTicket(ticket);
    }

    private void charge(Audience audience, Ticket ticket) {
        audience.pay(ticket.getFee());
        ticketOffice.plusAmount(ticket.getFee());
    }
}
