package com.wanted.preonboarding.theater.service.handler;

public class Audience {
    private final Bag bag;

    public Audience(Bag bag){
        this.bag = bag;
    }

    public Bag getBag(){ return bag;}


    public boolean hasInvitation() {
        return this.bag.hasInvitation();
    }

    public void receiveTicket(Ticket ticket) {
        this.bag.setTicket(ticket);
    }

    public void buyTicket(Ticket ticket) {
        receiveTicket(ticket);
        this.bag.minusAmount(ticket.getFee());
    }
}