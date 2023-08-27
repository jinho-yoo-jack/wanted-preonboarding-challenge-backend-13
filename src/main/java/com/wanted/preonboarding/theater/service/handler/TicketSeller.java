package com.wanted.preonboarding.theater.service.handler;

public class TicketSeller {
    private final TicketOffice ticketOffice;

    public TicketSeller(TicketOffice ticketOffice){
        this.ticketOffice = ticketOffice;
    }

    public Ticket getTicket(){
        return ticketOffice.getTicket();
    }

    public void plusAmount(long fee) {
        this.ticketOffice.setAmount(fee);
    }
}
