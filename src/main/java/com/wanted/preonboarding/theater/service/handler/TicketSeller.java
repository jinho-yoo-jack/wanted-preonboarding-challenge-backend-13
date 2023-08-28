package com.wanted.preonboarding.theater.service.handler;

public class TicketSeller {
    private final TicketOffice ticketOffice;

    public TicketSeller(long amount, long ticketFee) {
        this.ticketOffice = new TicketOffice(amount, new Ticket(ticketFee));
    }

    public void sellTicket(Audience audience) {
        Ticket ticket = ticketOffice.getTicket();
        audience.minusAmount(ticket.getFee());
        ticketOffice.plusAmount(ticket.getFee());
        audience.setTicket(ticket);
    }

    public Long getTicketFee(){
        return ticketOffice.getTicket().getFee();
    }

    public Long getOfficeAmount(){
        return ticketOffice.getAmount();
    }
}
