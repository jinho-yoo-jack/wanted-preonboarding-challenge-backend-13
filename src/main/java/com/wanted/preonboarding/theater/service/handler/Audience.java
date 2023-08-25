package com.wanted.preonboarding.theater.service.handler;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Audience {

    private final Bag bag;

    public Long buy(Ticket ticket) {

        if(bag.hasInvitation()) {
            bag.setTicket(ticket);
            return 0L;
        } else {
            bag.setTicket(ticket);
            bag.minusAmount(ticket.getFee());
            return ticket.getFee();
        }

    }

}