package com.wanted.preonboarding.theater.service.handler;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class TicketSeller {

    private final TicketOffice ticketOffice;

    public TicketSeller(TicketOffice ticketOffice){
        this.ticketOffice = ticketOffice;
    }

    public Ticket takeOutTicket() {

        return ticketOffice.getTicket();
    }

    public void putMoney(Long amount) {

        ticketOffice.plusAmount(amount);
    }
}
