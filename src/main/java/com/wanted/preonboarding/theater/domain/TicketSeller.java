package com.wanted.preonboarding.theater.domain;

import com.wanted.preonboarding.theater.domain.Audience;
import com.wanted.preonboarding.theater.domain.Ticket;
import com.wanted.preonboarding.theater.domain.TicketOffice;

public class TicketSeller {
    private final TicketOffice ticketOffice;

    public TicketSeller(TicketOffice ticketOffice){
        this.ticketOffice = ticketOffice;
    }

    public TicketOffice getTicketOffice(){
        return ticketOffice;
    }

    public Ticket changeTicket() {
        return ticketOffice.changeTicket();
    }

    public Ticket sellTo(Long money) {
        return ticketOffice.sellTicket(money);
    }
}
