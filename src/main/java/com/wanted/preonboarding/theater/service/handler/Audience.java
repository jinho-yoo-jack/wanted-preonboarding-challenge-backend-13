package com.wanted.preonboarding.theater.service.handler;

import com.wanted.preonboarding.theater.service.exception.LackOfBalanceException;

public class Audience {
    private final Bag bag;

    public static Audience from(Bag bag) {
        return new Audience(bag);
    }

    private Audience(Bag bag){
        this.bag = bag;
    }

    public Long buy(Ticket ticket) {
        return bag.hold(ticket);
    }
}