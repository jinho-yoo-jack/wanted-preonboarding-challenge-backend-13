package com.wanted.preonboarding.theater.theater.domain;

import com.wanted.preonboarding.theater.audience.domain.Audience;
import com.wanted.preonboarding.theater.ticket.domain.Ticket;
import com.wanted.preonboarding.theater.ticket.domain.TicketSeller;
import org.springframework.stereotype.Component;

@Component
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
