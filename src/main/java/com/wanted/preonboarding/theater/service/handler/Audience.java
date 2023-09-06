package com.wanted.preonboarding.theater.service.handler;

/**
 * 리펙토링한 부분:
 *                  - getBag보단 buy()을 public으로 둠으로써 Bag을 은닉화함.
 */

public class Audience {
    private final Bag bag;

    public Audience(Bag bag){
        this.bag = bag;
    }

    public long buy(Ticket t) throws Exception {
        return bag.putTicket(t);
    }
}