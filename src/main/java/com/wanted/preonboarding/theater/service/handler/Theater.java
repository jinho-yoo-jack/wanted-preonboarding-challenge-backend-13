package com.wanted.preonboarding.theater.service.handler;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Theater {
    private final TicketSeller ticketSeller;

    public String enter(Audience audience) {
        if (audience.hastTicket()) {
            return "Have a good time.";
        }

        throw new IllegalArgumentException("Fail to buy a ticket.");
    }

    public String sellTicketTo(Audience audience) {
        if (ticketSeller.sellTicketTo(audience)) {
            return "Success to buy a ticket.";
        }
        throw new IllegalArgumentException("Fail to buy a ticket.");
    }

    public void changeInvitation(Audience audience) {
        ticketSeller.changeInvitiactionByTicket(audience);
    }
}
