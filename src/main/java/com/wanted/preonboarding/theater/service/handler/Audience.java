package com.wanted.preonboarding.theater.service.handler;

import com.wanted.preonboarding.theater.dto.RequestMessage;

public class Audience {

    private final Bag bag;

    public Audience(Bag bag) {
        this.bag = bag;
    }

    public static Audience of(RequestMessage requestMessage) {
        Invitation invitation = null;
        if (requestMessage.hasInvitation()) {
            invitation = new Invitation();
        }
        return new Audience(new Bag(invitation, requestMessage.getAmount()));
    }

    public Bag getBag() {
        return bag;
    }

    public void buyTicket(Ticket ticket, TicketSeller ticketSeller) {
        bag.minusAmount(ticket.getFee());
        bag.setTicket(ticket);
        ticketSeller.sellTicket(ticket);
    }

    public boolean hasInvitation() {
        return bag.hasInvitation();
    }

    public void takeTicket(Ticket ticket) {
        bag.setTicket(ticket);
    }
}