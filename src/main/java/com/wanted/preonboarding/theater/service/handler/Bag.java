package com.wanted.preonboarding.theater.service.handler;

import com.wanted.preonboarding.theater.service.handler.dto.RequestMessage;

public class Bag {
    private Long amount;
    private final Invitation invitation;
    private Ticket ticket;

    public Bag(long amount){
        this(null, amount);
    }
    public Bag(Invitation invitation, long amount){
        this.invitation = invitation;
        this.amount = amount;
    }

    public static Bag createBag(RequestMessage request) {
        if (request.hasInvitation()){
            return new Bag(Invitation.createInvitation(), request.getAmount());
        } else {
            return new Bag(request.getAmount());
        }
    }

    public boolean hasInvitation() {
        return invitation != null && invitation.isAvailable();
    }

    public boolean hasTicket() {
        return ticket != null;
    }
    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
    public void minusAmount(long amount) {
        this.amount -= amount;
    }
    public void plusAmount(long amount) {
        this.amount += amount;
    }
}
