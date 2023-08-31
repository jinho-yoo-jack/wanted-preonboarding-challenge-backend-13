package com.wanted.preonboarding.theater.service.handler;

import lombok.Getter;

@Getter
public class Bag {
    private Money amount;
    private Invitation invitation;
    private Ticket ticket;

    public Bag(Money amount) {
        this(null, amount);
    }

    public Bag(Invitation invitation, Money amount) {
        this.invitation = invitation;
        this.amount = amount;
    }

    public boolean hasInvitation() {
        return invitation != null;
    }

    public boolean hasTicket() {
        return ticket != null;
    }


    public void minusAmount(Money money) {
        this.amount = this.amount.minus(money);
    }

    public void plusAmount(Money money) {
        this.amount = this.amount.plus(money);
    }

    public void exchageTicket(Ticket ticket) {
        this.invitation = null;
        this.ticket = ticket;
    }

    public void buy(Ticket ticket) {
        minusAmount(ticket.getFee());
        this.ticket = ticket;
    }
}
