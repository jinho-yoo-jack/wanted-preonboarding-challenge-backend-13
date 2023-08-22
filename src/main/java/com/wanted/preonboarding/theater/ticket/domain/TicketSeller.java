package com.wanted.preonboarding.theater.ticket.domain;

public class TicketSeller {
    private final TicketOffice ticketOffice;

    public TicketSeller(TicketOffice ticketOffice) {
        this.ticketOffice = ticketOffice;
    }

    public Ticket getTicket() {
        return this.ticketOffice.getTicket();
    }

    public void chargeAmount(long money) {
        this.ticketOffice.plusAmount(money);
    }
}
