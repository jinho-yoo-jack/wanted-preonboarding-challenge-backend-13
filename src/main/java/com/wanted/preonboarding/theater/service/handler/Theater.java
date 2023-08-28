package com.wanted.preonboarding.theater.service.handler;

import com.wanted.preonboarding.theater.domain.RequestMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class Theater {

    public void enter(Audience audience){
        TicketSeller ticketSeller = new TicketSeller(20000L, 100L);
        if(!audience.hasInvitation()){
            ticketSeller.sellTicket(audience);
        }
    }
}
