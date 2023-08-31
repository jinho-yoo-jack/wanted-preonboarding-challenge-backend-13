package com.wanted.preonboarding.theater.service.handler;

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

    public void takeTicketFrom(TicketSeller ticketSeller) {
        Ticket ticket = ticketSeller.issueTicketTo(this);
        bag.setTicket(ticket);
    }

    public void pay(long fee) {
        if (bag.getAmount() < fee) {
            throw new RuntimeException("Be short of money.");
        }

        this.bag.minusAmount(fee);
    }
}