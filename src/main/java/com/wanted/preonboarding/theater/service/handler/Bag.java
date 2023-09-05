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

    public Long getAmount() {
        return this.amount;
    }

    public boolean hasInvitation() {
        return invitation != null;
    }
    public boolean hasTicket() {
        return ticket != null;
    }

    public void exchangeInvitation(Ticket ticket) {
        if (this.hasInvitation()) {
            this.ticket = ticket;
            return;
        }
        throw new IllegalStateException("초대권이 없습니다.");
    }

    public Long buyTicket(Ticket ticket) {
        Long ticketFee = ticket.getFee();
        if(this.amount >= ticketFee) {
            this.amount -= ticketFee;
            this.ticket = ticket;
            return ticketFee;
        }
        throw new IllegalStateException("소지한 금액이 충분하지 않습니다.");
    }
}
