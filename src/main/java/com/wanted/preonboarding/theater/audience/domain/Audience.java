package com.wanted.preonboarding.theater.audience.domain;

import com.wanted.preonboarding.theater.ticket.domain.Ticket;

public class Audience {
    private long id;
    private final Bag bag;

    public Audience(Bag bag) {
        this.bag = bag;
    }


    public Audience() {
        this.bag = new Bag();
        this.id = 0L;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean hasInvitation() {
        return bag.hasInvitation();
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