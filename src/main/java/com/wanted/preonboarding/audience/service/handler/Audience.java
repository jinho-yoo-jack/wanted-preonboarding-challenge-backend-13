package com.wanted.preonboarding.audience.service.handler;

import com.wanted.preonboarding.theater.service.handler.Ticket;

public class Audience {
    private Long id;
    private final Bag bag;

    public Audience(Bag bag){
        this.bag = bag;
    }

    public Bag getBag(){ return bag;}

    public void buy(Ticket ticket) {
        this.bag.minusAmount(ticket.getFee());
        this.bag.setTicket(ticket);
    }
}