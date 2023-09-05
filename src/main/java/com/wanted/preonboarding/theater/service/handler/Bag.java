package com.wanted.preonboarding.theater.service.handler;

import lombok.Getter;

@Getter
public class Bag {
    private Long amount;
    private final Invitation invitation;
    private Ticket ticket;

    public Bag(long amount) {
        this(null, amount);
    }

    public Bag(Invitation invitation, long amount) {
        this.invitation = invitation;
        this.amount = amount;
    }

    public boolean hasTicket() {
        return ticket != null;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public void plusAmount(long amount) {
        this.amount += amount;
    }

    public void hold(Ticket ticket) {
        this.ticket = ticket;
        if (!hasInvitation()) minusAmount(ticket.getFee());
    }

    public boolean hasInvitation() {
        return invitation != null;
    }

    private void minusAmount(long amount) {
        this.amount -= amount;
    }

}
