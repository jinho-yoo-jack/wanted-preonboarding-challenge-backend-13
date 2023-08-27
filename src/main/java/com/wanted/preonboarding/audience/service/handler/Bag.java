package com.wanted.preonboarding.audience.service.handler;

import com.wanted.preonboarding.common.exception.NotEnoughMoneyException;
import com.wanted.preonboarding.theater.service.handler.Ticket;

import java.time.LocalDateTime;

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
    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
    public void minusAmount(long ticketPrice) {
        if (this.amount - ticketPrice >= 0) {
            this.amount -= amount;
        } else {
            throw new NotEnoughMoneyException();
        }
    }
    public void plusAmount(long amount) {
        this.amount += amount;
    }
    public Invitation getInvitation() {
        return this.invitation;
    }

    public boolean hasValidInvitation(LocalDateTime now) {
        if (hasInvitation()) {
            return !getInvitation().isExpired(now);
        }

        return false;
    }
}
