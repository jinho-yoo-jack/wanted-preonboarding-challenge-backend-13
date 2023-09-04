package com.wanted.preonboarding.theater.service.handler;

public class Audience {
    private final Bag bag;

    public Audience(Bag bag){
        this.bag = bag;
    }

    public Long buyTicket(Ticket ticket){
        bag.setTicket(ticket);

        if(bag.hasInvitation()){
            return 0L;
        }else{
            bag.minusAmount(ticket.getFee());
            return ticket.getFee();
        }
    }
}