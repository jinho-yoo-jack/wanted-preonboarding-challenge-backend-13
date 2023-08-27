package com.wanted.preonboarding.theater.service.handler;

import lombok.Builder;

public class TicketSeller {
    private final TicketOffice ticketOffice;

    @Builder
    public TicketSeller(TicketOffice ticketOffice){
        this.ticketOffice = ticketOffice;
    }

    public static TicketSeller createTicketSeller(TicketOffice ticketOffice) {
        return TicketSeller.builder()
                .ticketOffice(ticketOffice)
                .build();
    }

    public Ticket sellTicket() {
        Ticket ticket = this.ticketOffice.getTicket();
        this.ticketOffice.plusAmount(ticket.getFee());
        return ticket;
    }

    public TicketOffice getTicketOffice(){
        return ticketOffice;
    }


}
