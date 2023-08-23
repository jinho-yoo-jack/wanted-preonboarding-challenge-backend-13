package com.wanted.preonboarding.theater.service.handler;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@ToString
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

    @Builder
    public Bag(Long amount, Invitation invitation, Ticket ticket) {
        this.amount = amount;
        this.invitation = invitation;
        this.ticket = ticket;
    }

    public boolean hasInvitation() {
        return invitation != null;
    }
    public boolean hasTicket() {
        return ticket != null;
    }

    public Ticket getTicket() {
        return ticket;
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

    public Long getAmount() {
        return amount;
    }
}
