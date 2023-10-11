package com.wanted.preonboarding.theater.service.handler;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class Theater {

    public void enter(Audience audience, TicketSeller ticketSeller){
        long ticketFee = ticketSeller.sellTo(audience);
        ticketSeller.receivePay(ticketFee);
    }

}
