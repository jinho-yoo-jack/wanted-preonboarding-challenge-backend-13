package com.wanted.preonboarding.theater.service.handler;

import java.util.Optional;

public record Audience(String name, Bag bag) {

    public Long getMoney() {
        return this.bag().getAmount();
    }

    public Optional<Invitation> getInvitation() {
        return this.bag().getInvitation();
    }

    public boolean hasTicket() {
        return this.bag().getTicket() != null;
    }

    public Ticket getTicket() {
        return this.bag().getTicket();
    }

    public void purchaseTicket(Ticket ticket) {
        this.bag().minusAmount(ticket.getFee());
    }

    public void refundTicket(Ticket ticket) {
        this.bag().plusAmount(ticket.getFee());
        removeTicket();
    }

    public void removeTicket() {
        this.bag().setTicket(null);
    }

    public void takeTicket(Ticket ticket) {
        this.bag().setTicket(ticket);
    }
}