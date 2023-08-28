package com.wanted.preonboarding.theater.service.handler;

import lombok.Builder;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Builder
public class Audience {
    private final Bag bag;

    public Audience(Bag bag){
        this.bag = bag;
    }

    public Bag getBag(){
        return bag;
    }

    public boolean hasInvitation() {
        return bag.hasInvitation();
    }

    public void buyTicket(TicketSeller ticketSeller) {
        TicketOffice ticketOffice = ticketSeller.getTicketOffice();
        Ticket ticket = ticketOffice.getTicket();

        if(!hasInvitation()) {
            log.info("티켓 구매");
            bag.minusAmount(ticket.getFee());
            ticketOffice.plusAmount(ticket.getFee());
        }
        bag.setTicket(ticket);
    }
}