package com.wanted.preonboarding.theater.service.handler;

import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class Theater {
    public void enter(Audience audience, TicketSeller ticketSeller){
        Assert.notNull(audience, "Audience is required.");

        if (!audience.hasTicket()) {
            ticketSeller.sellTicketsTo(audience);
        }

        // enter
    }
}
