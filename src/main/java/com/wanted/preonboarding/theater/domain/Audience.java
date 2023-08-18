package com.wanted.preonboarding.theater.domain;

public class Audience {
    private final Bag bag;

    public Audience(Bag bag) {
        this.bag = bag;
    }

    public Bag getBag() {
        return bag;
    }

    public void putTicketInBag(Ticket ticket) {
        this.bag.setTicket(ticket);
    }

    public void dischargeAmount(long money) {
        this.bag.minusAmount(money);
    }
}