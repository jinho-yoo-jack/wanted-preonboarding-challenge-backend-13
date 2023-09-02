package com.wanted.preonboarding.theater.service.handler;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TicketSeller {
    private final TicketOffice ticketOffice;

    public void sellTo(Audience audience) {
        if (audience.hasInvitation()) {
            ticketOffice.receiveTicket(audience.getBag());
        } else {
            ticketOffice.sellTicket(audience.getBag());
        }
    }
}
