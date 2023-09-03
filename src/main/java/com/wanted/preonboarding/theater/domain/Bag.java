package com.wanted.preonboarding.theater.domain;

public class Bag {
    private Long amount;
    private final Invitation invitation;
    private Ticket ticket;

    public Bag(Invitation invitation, Ticket ticket, long amount) {
        this.invitation = invitation;
        this.ticket = ticket;
        this.amount = amount;
    }

    public void buyTiket(Ticket ticket) {
        this.ticket = ticket;
        minusAmount(ticket.getFee());
    }

    public void changeTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public Long inMoney() {
        return amount;
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
    private void minusAmount(long amount) {
        this.amount -= amount;
    }
    public void plusAmount(long amount) {
        this.amount += amount;
    }
}
