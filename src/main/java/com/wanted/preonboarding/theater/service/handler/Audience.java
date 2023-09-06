package com.wanted.preonboarding.theater.service.handler;

public class Audience {
    private final Bag bag;

    public Audience(Bag bag){
        this.bag = bag;
    }

    public long getAmount(){ return bag.getAmount();}

    public boolean doesInvited(){
        return this.bag.hasInvitation();
    }

    public void holdTicket(Ticket ticket){
        this.bag.setTicket(ticket);
    }

    public void pay(long amount){
        this.bag.minusAmount(amount);
    }
}