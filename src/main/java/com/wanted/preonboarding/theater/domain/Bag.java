package com.wanted.preonboarding.theater.domain;

import lombok.Builder;

public class Bag {
    private Long amount;
    private final Invitation invitation;
    private Ticket ticket;

    public Bag(long amount) {
        this(null, amount);
    }

    @Builder
    public Bag(Invitation invitation, long amount) {
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
        if (this.amount - amount >= 0) {
            this.amount -= amount;
        } else {
            throw new IllegalArgumentException("잔액이 부족합니다");
        }

    }
    public void plusAmount(long amount) {
        this.amount += amount;
    }
}
