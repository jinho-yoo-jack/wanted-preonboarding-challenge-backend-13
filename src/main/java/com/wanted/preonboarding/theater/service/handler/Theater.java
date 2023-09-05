package com.wanted.preonboarding.theater.service.handler;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class Theater {

    private final TicketSeller ticketSeller;

    public void enter(Audience audience){
        ticketSeller.sellTo(audience);
    }
}
