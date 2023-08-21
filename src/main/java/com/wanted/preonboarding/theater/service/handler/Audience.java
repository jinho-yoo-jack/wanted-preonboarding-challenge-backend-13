package com.wanted.preonboarding.theater.service.handler;

import lombok.ToString;

@ToString
public class Audience {
    private final Bag bag;

    public Audience(Bag bag){
        this.bag = bag;
    }

    public boolean hasInvitation() {
        return this.bag != null && this.bag.hasInvitation();
    }

    public void setTicket(Ticket ticket) {
        this.bag.setTicket(ticket);
    }

    public boolean hasTicket() {
        return this.bag.hasTicket();
    }

    public void minusAmount(Long fee) {
        this.bag.minusAmount(fee);
    }
}