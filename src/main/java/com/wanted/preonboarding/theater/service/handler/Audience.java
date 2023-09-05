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

    public long buyTicket(Ticket ticket) {
        return bag.checkInvitation(ticket);
    }
}