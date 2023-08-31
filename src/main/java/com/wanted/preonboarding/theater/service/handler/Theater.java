package com.wanted.preonboarding.theater.service.handler;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class Theater {
    public void enter(Audience audience, TicketSeller ticketSeller){
        if (!audience.hasTicket()) {
            // 티켓이 없으면 티켓 발급
            audience.takeTicketFrom(ticketSeller);
        }

        // 티켓이 있으면 입장
    }
}
