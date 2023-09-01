package com.wanted.preonboarding.theater.service.handler;

import com.wanted.preonboarding.theater.service.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Theater {
    private TicketSeller ticketSeller;

    @Autowired
    public Theater() {
        this.ticketSeller = new TicketSeller(new TicketOffice(20000L, new Ticket(100L)));
    }

    public void enter(Audience audience) {
        if (hasInvitation(audience)) {
            Ticket ticket = ticketSeller.getTicket();
            audience.changeInvitationToTicket(ticket);
        } else {
            Ticket ticket = ticketSeller.sellTicket();
            audience.buyTicket(ticket);
        }
    }

    private boolean hasInvitation(Audience audience) {
        return audience.hasInvitation();
    }


}
