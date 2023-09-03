package com.wanted.preonboarding.theater.domain;

import com.wanted.preonboarding.theater.dto.ViewRequest;

public class Bag {
    private Long amount;
    private final Invitation invitation;
    private Ticket ticket;

    public static Bag fromViewRequest(ViewRequest viewRequest) {
        return new Bag(viewRequest.isInvitation(), viewRequest.getAmount());
    }

    public Bag(boolean isInvitation, Long amount) {
        this.invitation = isInvitation ? new Invitation() : null;
        this.amount = amount;
    }

    public Long pay(Long amount) {
        if (0L > this.amount || amount > this.amount) {
            throw new IllegalArgumentException();
        }
        minusAmount(amount);

        return amount;
    }

    public boolean hasInvitation() {
        return invitation != null;
    }

    public Ticket presentTicket() {
        return ticket;
    }

    public boolean hasTicket() {
        return ticket != null;
    }

    public void acquireTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public void minusAmount(long amount) {
        this.amount -= amount;
    }

    public void plusAmount(long amount) {
        this.amount += amount;
    }
}
