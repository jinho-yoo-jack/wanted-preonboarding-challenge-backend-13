package com.wanted.preonboarding.theater.service.handler;

import org.hibernate.mapping.Bag;

import com.wanted.preonboarding.theater.service.model.RequestMessage;

public class Audience {
    private Long money;
    private final Invitation invitation;
    private Ticket ticket;

    public Audience(long money){
        this(null, money);
    }
    public Audience(Invitation invitation, long money){
        this.invitation = invitation;
        this.money = money;
    }

    public static Audience of(RequestMessage requestMessage){
        Invitation invitation = null;
        if (requestMessage.getHasInvitation()) {
            invitation = new Invitation();
        }
        return new Audience(invitation, requestMessage.getMoney());
    }

    public boolean hasInvitation() {
        return invitation != null;
    }
    public boolean hasTicket() {
        return ticket != null;
    }
    public void receiveTicket(Ticket ticket) {
        this.ticket = ticket;
    }
    public void payFee(long money) {
        this.money -= money;
    }
    public void refundFee(long money) {
        this.money += money;
    }
}