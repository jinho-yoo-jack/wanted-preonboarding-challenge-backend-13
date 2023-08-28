package com.wanted.preonboarding.theater.service.handler;

public class TicketSeller {
    private final TicketOffice ticketOffice;

    public TicketSeller(TicketOffice ticketOffice) {
        this.ticketOffice = ticketOffice;
    }

    public TicketOffice getTicketOffice() {
        return ticketOffice;
    }

    public void sellTicket(Audience audience) {
        Ticket ticket = ticketOffice.getTicket();
        Long ticketFee = ticket.getFee();
        audience.payFee(ticketFee);
        ticketOffice.plusAmount(ticketFee);
        audience.receiveTicket(ticket);
    }

    public void convertInvitationToTicket(Audience audience) {
        Ticket ticket = ticketOffice.getTicket();
        audience.receiveTicket(ticket);
    }
}
