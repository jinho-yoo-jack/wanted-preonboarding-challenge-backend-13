package com.wanted.preonboarding.theater.service.handler;

public class Audience {
    private final Bag bag;

    public Audience(Bag bag){
        this.bag = bag;
    }

    public Bag getBag(){ return bag;}

    public long buy(Ticket ticket) {
        return bag.buy(ticket);
    }
}