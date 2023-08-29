package com.wanted.preonboarding.theater.service.handler;

import lombok.Builder;

public class Bag {
    private Long amount;
    private final Invitation invitation;
    private Ticket ticket;


    @Builder
    public Bag(Invitation invitation, Long amount){
        this.invitation = invitation;
        this.amount = amount;
    }

    public boolean hasInvitation() {
        return invitation != null;
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
