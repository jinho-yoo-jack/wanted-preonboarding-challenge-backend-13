package com.wanted.preonboarding.theater.service.handler;

public class TicketSeller {
    private final TicketOffice ticketOffice;

    public TicketSeller(TicketOffice ticketOffice) {
        this.ticketOffice = ticketOffice;
    }

    public void sellTicket(Audience audience) {
        Ticket ticket = ticketOffice.getTicket();
        Long paidAmount = audience.buy(ticket);
        ticketOffice.plusAmount(paidAmount);
    }
}
