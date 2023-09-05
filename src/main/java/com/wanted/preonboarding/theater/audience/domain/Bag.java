package com.wanted.preonboarding.theater.audience.domain;

import com.wanted.preonboarding.theater.ticket.domain.Ticket;


public class Bag {

    private final Invitation invitation;
    private Long amount;

    private Ticket ticket;

    public Bag(long amount) {
        this(null, amount);
    }

    public Bag(Invitation invitation, long amount) {
        this.invitation = invitation;
        this.amount = amount;
    }

    public Bag() {
        this.amount = 0L;
        this.invitation = new Invitation();
        this.ticket = new Ticket();
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

    public long getAmount() {
        return this.amount;
    }
}
