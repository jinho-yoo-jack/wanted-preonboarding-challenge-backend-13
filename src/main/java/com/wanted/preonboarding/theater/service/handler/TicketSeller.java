package com.wanted.preonboarding.theater.service.handler;

public class TicketSeller {
    private final TicketOffice ticketOffice;

    public TicketSeller(TicketOffice ticketOffice){
        this.ticketOffice = ticketOffice;
    }

    public long sellTo(Audience a) {
        return a.buyTicket(ticketOffice.issueTicket());
    }

    public void receivePay(long ticketFee) {
        ticketOffice.increaseSalesAmount(ticketFee);
    }
}
