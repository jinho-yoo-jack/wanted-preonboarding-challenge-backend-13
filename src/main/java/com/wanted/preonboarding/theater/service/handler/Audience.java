package com.wanted.preonboarding.theater.service.handler;

public class Audience {
    private final Bag bag;

    public Audience(Bag bag){
        this.bag = bag;
    }

    public Bag getBag(){ return bag;}

    public Boolean hasInvitation() {
       return this.bag.hasInvitation();
    }

    public void exchangeInvitation(Ticket ticket) {
        this.bag.exchangeInvitation(ticket);
    }

    public Long buyTicket(Ticket ticket) {
        return this.bag.buyTicket(ticket);
    }
}