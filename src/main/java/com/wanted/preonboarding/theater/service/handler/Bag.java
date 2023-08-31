package com.wanted.preonboarding.theater.service.handler;

import com.wanted.preonboarding.theater.dto.RequestMessage;

public class Bag {
    private Long amount;
    private final Invitation invitation;
    private Ticket ticket;

    public Bag(RequestMessage requestMessage) {
        this.amount = requestMessage.getAmount();
        this.invitation = requestMessage.getInvitation();
    }

    public boolean hasInvitation() {
        return invitation != null;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public void minusAmount(long amount) {
        this.amount -= amount;
    }
}
