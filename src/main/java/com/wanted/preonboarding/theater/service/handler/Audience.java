package com.wanted.preonboarding.theater.service.handler;

public class Audience {
    private final Bag bag;

    public Audience(Bag bag){
        this.bag = bag;
    }

    public Bag getBag(){ return bag;}
    
    public boolean hasTicket() {
        return bag.hasTicket();
    } 
    
    public void enterTheater(Theater theater) {
        if (hasTicket()) {
            theater.checkTicket(this);
        } else {
            theater.sellTicket(this);
        }
    }
}