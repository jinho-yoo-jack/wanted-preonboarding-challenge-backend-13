package com.wanted.preonboarding.theater.service.handler;

public class Audience {

    private final Bag bag;

    public Audience(Bag bag){
        this.bag = bag;
    }

    public Bag getBag(){ return bag;}

    public long buy(Ticket ticket) {
        if (bag.hasInvitation()){
            bag.setTicket(ticket);
            return 0L;
        } else {
            bag.minusAmount(ticket.getFee());
            bag.setTicket(ticket);
            return ticket.getFee();
        }
    }

}