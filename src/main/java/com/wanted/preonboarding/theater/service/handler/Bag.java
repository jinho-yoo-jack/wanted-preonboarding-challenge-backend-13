package com.wanted.preonboarding.theater.service.handler;

import com.wanted.preonboarding.theater.service.exception.LackOfBalanceException;

public class Bag {
    private Long amount;
    private final Invitation invitation;
    private Ticket ticket;

    private Bag(long amount){
        this(null, amount);
    }
    private Bag(Invitation invitation, long amount){
        this.invitation = invitation;
        this.amount = amount;
    }

    public static Bag from(long amount) {
        return new Bag(null, amount);
    }

    public static Bag of(Invitation invitation, long amount){
        return new Bag(invitation, amount);
    }

    public boolean hasInvitation() {
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

    private boolean hasEnoughAmount(long pay) {
        return this.amount >= pay;
    }

    public Long hold(Ticket ticket) {
        if (hasInvitation()) {
            setTicket(ticket);
            return 0L;
        } else if (hasEnoughAmount(ticket.getFee())) {
            minusAmount(ticket.getFee());
            setTicket(ticket);
            return ticket.getFee();
        }
        throw LackOfBalanceException.builder()
                .requiredAmount(ticket.getFee())
                .currentBalance(amount).build();
    }
}
