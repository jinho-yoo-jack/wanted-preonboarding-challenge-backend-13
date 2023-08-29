package com.wanted.preonboarding.theater.service.handler;

import lombok.Getter;

@Getter
public class Bag {
    private Long amount; //돈
    private final Invitation invitation; //초대장
    private Ticket ticket; //티켓


    public Bag(long amount,Invitation invitation){
        this.amount = amount;
        this.invitation = invitation;
    }

    public boolean hasInvitation() {

        return invitation.getWhen() != null;
    }
    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
    public void minusAmount(long amount) {
        this.amount -= amount;
    }

}
