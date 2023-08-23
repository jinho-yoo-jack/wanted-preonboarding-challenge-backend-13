package com.wanted.preonboarding.theater.theater.domain;

import com.wanted.preonboarding.theater.audience.domain.Audience;
import com.wanted.preonboarding.theater.ticket.application.TicketOffice;
import com.wanted.preonboarding.theater.ticket.domain.Ticket;

public class TicketSeller {
    private final Audience audience;
    private final TicketOffice ticketOffice;

    private final Ticket ticket;

    public TicketSeller(Audience audience, Ticket ticket, TicketOffice ticketOffice) {
        this.audience = audience;
        this.ticket = ticket;
        this.ticketOffice = ticketOffice;
    }

    public void sellTicket() {

        if (audience.hasInvitation()) {
            audience.putTicketInBag(ticket);
        } else {
            calculateCharge();
            audience.putTicketInBag(ticket);
        }
    }

    private void calculateCharge() {
        final long fee = ticket.getFee();
        audience.dischargeAmount(fee);
        ticketOffice.chargeAmount(fee);
    }
}
