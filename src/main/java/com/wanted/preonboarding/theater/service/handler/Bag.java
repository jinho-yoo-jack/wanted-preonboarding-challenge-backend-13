package com.wanted.preonboarding.theater.service.handler;

import com.wanted.preonboarding.theater.exception.TheaterErrorCode;
import com.wanted.preonboarding.theater.exception.TheaterException;

public class Bag {

    private Long amount;
    private Invitation invitation;
    private Ticket ticket;

    public Bag() {}

    public Bag(long amount){
        this(null, amount);
    }

    public Bag(Invitation invitation, long amount){
        this.invitation = invitation;
        this.amount = amount;
    }

    public Long getAmount() {
        return amount;
    }

    public Invitation getInvitation() {
        return this.invitation;
    }

    public Ticket getTicket() {
        return this.ticket;
    }

    public void takeTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public void payForTicket(long ticketPrice) {
        if (this.amount < ticketPrice) {
            throw new TheaterException(TheaterErrorCode.NOT_ENOUGH_MONEY);
        }
        this.amount -= ticketPrice;
    }

    public void takeForRefund(long ticketPrice) {
        this.amount += ticketPrice;
    }

    public boolean hasInvitation() {
        return this.invitation != null;
    }

    public boolean hasTicket() {
        return this.ticket != null;
    }

    public Ticket refundTicket() {
        Ticket returnTicket = this.ticket;
        this.ticket = null;
        return returnTicket;
    }

    public boolean isValidInvitation() {
        return this.invitation.verifyInvitation();
    }
}
