package com.wanted.preonboarding.theater.service.handler;

public class TicketSeller {
    private final TicketOffice ticketOffice;

    public TicketSeller(TicketOffice ticketOffice){
        this.ticketOffice = ticketOffice;
    }

    public Ticket issueTicket(){
        return ticketOffice.getTicket();
    }

    public void deposit(Long amount){
        ticketOffice.plusAmount(amount);
    }
}
