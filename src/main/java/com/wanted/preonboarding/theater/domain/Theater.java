package com.wanted.preonboarding.theater.domain;

public class Theater {

    public void enter(Audience audience, TicketSeller ticketSeller) {
        if (audience.getBag().hasInvitation()) {
            Ticket ticket = ticketSeller.getTicket();
            audience.putTicketInBag(ticket);
        } else {
            Ticket ticket = ticketSeller.getTicket();
            final Long fee = ticket.getFee();
            audience.dischargeAmount(fee);
            ticketSeller.chargeAmount(fee);
            audience.putTicketInBag(ticket);
        }
    }
}
