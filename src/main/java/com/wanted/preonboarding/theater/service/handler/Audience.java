package com.wanted.preonboarding.theater.service.handler;

public class Audience {
    private final Bag bag;

    public Audience(Bag bag){
        this.bag = bag;
    }

    public Bag getBag(){ return bag;}
    public boolean hasInvitation(){
        return bag.hasInvitation();
    }
    public boolean hasTicket(){
        return bag.hasTicket();
    }

    public void buyTicket(Ticket ticket){
        this.bag.minusAmount(ticket.getFee());
    }

//    초대장 확인 ->
    public void changeInvitationToTicket(Ticket ticket){
        this.bag.setTicket(ticket);
    }
}