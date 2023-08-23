package com.wanted.preonboarding.theater.service.handler;

import lombok.Builder;
import lombok.ToString;

@ToString
@Builder
public class Audience {
    private final Bag bag;

    public Audience(Bag bag){
        this.bag = bag;
    }

    public Bag getBag(){ return bag;}

    public boolean hasInvitation(){
        return bag.hasInvitation();
    }

    public void setTicket(Ticket ticket){
        bag.setTicket(ticket);
    }

    public Long getAmount(){
        return bag.getAmount();
    }

    public Ticket getTicket(){
        return bag.getTicket();
    }

}