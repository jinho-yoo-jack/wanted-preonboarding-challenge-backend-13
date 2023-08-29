package com.wanted.preonboarding.theater.service.handler;

import org.springframework.util.Assert;

import lombok.Builder;

public class Audience {
    private final Bag bag;

    @Builder
    public Audience(Bag bag){
        this.bag = bag;
    }

    public Bag getBag(){ return bag;}

    public boolean hasInvitation() {
        return bag.hasInvitation();
    }

    public boolean hasTicket() {
        return bag.hasTicket();
    }

    public void exchangeFor(Ticket ticket) {
        Assert.notNull(ticket, "Ticket is required.");

        if (!hasInvitation()) {
            throw new RuntimeException("Have no invitation.");
        }

        bag.setTicket(ticket);
    }

    public void buy(Ticket ticket) {
        Assert.notNull(ticket, "Ticket is required.");

        if (bag.getAmount() < ticket.getFee()) {
            throw new RuntimeException("Be short of money.");
        }

        bag.setTicket(ticket);
        bag.minusAmount(ticket.getFee());
    }
}