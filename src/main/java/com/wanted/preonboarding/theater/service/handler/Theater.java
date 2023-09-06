package com.wanted.preonboarding.theater.service.handler;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Theater {

    public void enter(Audience audience, TicketSeller ticketSeller) {
        if (audience.doesInvited()) {
            ticketSeller.giveTo(audience);
            return;
        }
        ticketSeller.sellTo(audience);
    }
}
