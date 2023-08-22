package com.wanted.preonboarding.theater.service.handler;

import java.util.Optional;

class Bag {

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

    public Long getAmount() {
        return amount;
    }

    public Optional<Invitation> getInvitation() {
        return Optional.ofNullable(this.invitation);
    }

    public Ticket getTicket() {
        return this.ticket;
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
