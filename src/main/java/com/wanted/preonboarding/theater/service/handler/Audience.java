package com.wanted.preonboarding.theater.service.handler;

import com.wanted.preonboarding.theater.service.dto.AudienceDto;

public class Audience {
    private final Bag bag;

    public Audience(Bag bag){
        this.bag = bag;
    }

    public Bag getBag(){ return bag;}

    public static Audience from(AudienceDto audienceDto){
        Invitation invitation=null;
        if(audienceDto.getWhen()!=null){
            invitation=new Invitation(audienceDto.getWhen());
        }
        return new Audience(new Bag(invitation,audienceDto.getAmount()));
    }

    public void receiveTicket(Ticket ticket){
        bag.setTicket(ticket);
    }
    public Boolean hasInvitation(){
        return bag.hasInvitation();
    }

    public Boolean payFeeTo(TicketSeller ticketSeller){
        Long amount=ticketSeller.getTicketFee();
        if(bag.getAmount()>=amount) {
            bag.minusAmount(amount);
            ticketSeller.receiveFee(amount);
            return true;
        }
        return false;
    }


}