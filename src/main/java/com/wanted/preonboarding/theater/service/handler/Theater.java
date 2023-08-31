package com.wanted.preonboarding.theater.service.handler;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Theater {

    private final TicketSeller ticketSeller;

    public boolean enter(Audience audience) {
        return ticketSeller.checkTicket(audience);
    }
}
