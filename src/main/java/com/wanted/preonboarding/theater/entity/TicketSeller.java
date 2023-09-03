package com.wanted.preonboarding.theater.entity;

import lombok.Builder;

import java.util.List;

public class TicketSeller {
    private final TicketOffice ticketOffice;

    @Builder
    public TicketSeller(TicketOffice ticketOffice){
        this.ticketOffice = ticketOffice;
    }

    public TicketOffice getTicketOffice(){
        return ticketOffice;
    }

    public static TicketSeller init() {
        TicketOffice ticketOffice = TicketOffice.builder()
                .amount(20000L)
                .tickets(List.of(new Ticket(100L)))
                .build();

        return TicketSeller.builder()
                .ticketOffice(ticketOffice)
                .build();
    }
}
