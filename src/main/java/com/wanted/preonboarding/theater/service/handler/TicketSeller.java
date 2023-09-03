package com.wanted.preonboarding.theater.service.handler;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TicketSeller {
    private final TicketOffice ticketOffice;

    public Ticket sellTicket(Long fee) {
        ticketOffice.plusAmount(fee);
        return ticketOffice.getTicket();
    }
}
