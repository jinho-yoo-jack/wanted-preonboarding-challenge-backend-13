package com.wanted.preonboarding.theater.service.handler;

import lombok.Getter;

@Getter
public class Audience {
    private final Bag bag;

    public Audience(Bag bag){
        this.bag = bag;
    }

    public boolean hasInvitation() {
        return bag.hasInvitation();
    }

    public Money buy(Ticket ticket) {
        bag.buy(ticket);
        return ticket.getFee();
    }

    public Ticket exchangeTicket(Ticket ticket) {
        bag.exchageTicket(ticket);
        return ticket;
    }

    public boolean hastTicket() {
        return bag.hasTicket();
    }

    public Money getAmount() {
        return bag.getAmount();
    }
}