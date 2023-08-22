package com.wanted.preonboarding.theater.ticket.application;

import com.wanted.preonboarding.theater.ticket.domain.Ticket;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


public class TicketSeller {
    private final TicketOffice ticketOffice;

    public TicketSeller (TicketOffice ticketOffice) {
//        this.ticketOffice = ticketOffice //TODO: 여기
    }

    public Ticket getTicket(long id) {
        return this.ticketOffice.getTicket(id);
    }

    public void chargeAmount(long money) {
        this.ticketOffice.plusAmount(money);
    }
}
