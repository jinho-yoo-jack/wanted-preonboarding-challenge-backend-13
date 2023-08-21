package com.wanted.preonboarding.theater.service.handler;

public class TicketSeller {

    private final TicketOffice ticketOffice;

    public TicketSeller(TicketOffice ticketOffice) {
        this.ticketOffice = ticketOffice;
    }

    public Ticket publishTicket() {
        return this.ticketOffice.getTicket();
    }

    public void addAmount(Long fee) {
        this.ticketOffice.plusAmount(fee);
    }
}
