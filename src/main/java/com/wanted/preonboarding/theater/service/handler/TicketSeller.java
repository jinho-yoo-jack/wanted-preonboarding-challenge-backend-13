package com.wanted.preonboarding.theater.service.handler;

public class TicketSeller {
    private final TicketOffice ticketOffice;

    public TicketSeller(TicketOffice ticketOffice){
        this.ticketOffice = ticketOffice;
    }

    public TicketOffice getTicketOffice(){
        return ticketOffice;
    }

    public Long getTicketFee(){
        return ticketOffice.getTicket().getFee();
    }
    public void giveTicketTo(Audience audience){
        audience.receiveTicket(ticketOffice.getTicket());
    }

    public void receiveFee(Long amount){
        ticketOffice.plusAmount(amount);
    }
}
