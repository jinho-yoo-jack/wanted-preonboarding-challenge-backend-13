package com.wanted.preonboarding.theater.service.handler;

import com.wanted.preonboarding.theater.exception.TheaterErrorCode;
import com.wanted.preonboarding.theater.exception.TheaterException;
import lombok.Getter;

import java.util.Optional;

@Getter
public class Audience {

    private String name;
    private Bag bag;

    public Audience(String name, Bag bag) {
        this.name = name;
        this.bag = bag;
    }

    public Long getMoney() {
        return this.bag.getAmount();
    }

    public Optional<Invitation> getInvitation() {
        return this.bag.getInvitation();
    }

    public void hasTicket() {
        if (this.bag.getTicket() == null) {
            throw new TheaterException(TheaterErrorCode.NOT_FOUND_TICKET);
        }
    }

    public Ticket getTicket() {
        return this.bag.getTicket();
    }

    public void purchaseTicket(Ticket ticket) {
        this.bag.minusAmount(ticket.getFee());
    }

    public void refundTicket(Ticket ticket) {
        this.bag.plusAmount(ticket.getFee());
        removeTicket();
    }

    public void removeTicket() {
        this.bag.setTicket(null);
    }

    public void takeTicket(Ticket ticket) {
        this.bag.setTicket(ticket);
    }
}