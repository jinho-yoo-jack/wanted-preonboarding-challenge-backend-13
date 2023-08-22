package com.wanted.preonboarding.theater.service.handler;

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

    public boolean hasInvitation() {
        return invitation != null;
    }
    public boolean hasTicket() {
        return ticket != null;
    }
    public void receiveTicket(Ticket ticket) {
        this.ticket = ticket;
    }
    public void buyTicket(long amount) {
        if (this.amount < amount) {
            throw new RuntimeException("티켓 구매 비용이 부족합니다.");
        }
        this.amount -= amount;
    }
    public void plusAmount(long amount) {
        this.amount += amount;
    }
}
