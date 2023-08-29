package com.wanted.preonboarding.theater.service.handler;

import lombok.Builder;
import lombok.ToString;

@ToString
public class Audience {
    private final Bag bag;

    @Builder
    public Audience(Bag bag){
        this.bag = bag;
    }

    public boolean buyTicket(Ticket ticket) {
        if (!bag.hasInvitation()) {
            bag.minusAmount(ticket.getFee());
            bag.setTicket(ticket);
            return true;
        }
        return false;
    }
}