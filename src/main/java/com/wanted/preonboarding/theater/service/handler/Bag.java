package com.wanted.preonboarding.theater.service.handler;

import lombok.Builder;

public class Bag {
    private Long amount;
    private final Invitation invitation;
    private Ticket ticket;


    @Builder
    public Bag(Invitation invitation, Long amount){
        this.invitation = invitation;
        this.amount = amount;
    }

    public Long checkInvitation(Ticket ticket) {
        if (hasInvitation()) {
            setTicket(ticket);
            return 0L;
        } else {
            setTicket(ticket);
            minusAmount(ticket.getFee());
            return ticket.getFee();
        }
    }

    private boolean hasInvitation() {
        return invitation != null;
    }
    private boolean hasTicket() {
        return ticket != null;
    }
    private void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
    private void minusAmount(long amount) {
        this.amount -= amount;
    }
    private void plusAmount(long amount) {
        this.amount += amount;
    }
}
