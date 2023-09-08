package com.wanted.preonboarding.theater.service.handler;

import com.wanted.preonboarding.theater.exception.TheaterErrorCode;
import com.wanted.preonboarding.theater.exception.TheaterException;

public class Audience {

    private String name;
    private Bag bag;

    public Audience(String name, Bag bag) {
        this.name = name;
        this.bag = bag;
    }

    public String getName() {
        return this.name;
    }

    public Long getMoney() {
        return this.bag.getAmount();
    }

    public boolean hasInvitation() {
        return this.bag.hasInvitation();
    }

    public Invitation getInvitation() {
        if (hasInvitation()) {
            return bag.getInvitation();
        }
        throw new TheaterException(TheaterErrorCode.NOT_FOUND_INVITATION);
    }

    public boolean isValidInvitation() {
        return this.bag.isValidInvitation();
    }

    public boolean hasTicket() {
        return this.bag.hasTicket();
    }

    public void takeTicket(Ticket ticket) {
        this.bag.takeTicket(ticket);
    }

    public void takeRefundMoney(long ticketPrice) {
        this.bag.takeForRefund(ticketPrice);
    }

    public Ticket getTicket() {
        return this.bag.getTicket();
    }

    public void buyTicket(Ticket ticket) {
        this.bag.payForTicket(ticket.getFee());
    }

    public Ticket refundTicket() {
        if (!hasTicket()) {
            throw new TheaterException(TheaterErrorCode.NOT_FOUND_TICKET);
        }
        return this.bag.refundTicket();
    }
}