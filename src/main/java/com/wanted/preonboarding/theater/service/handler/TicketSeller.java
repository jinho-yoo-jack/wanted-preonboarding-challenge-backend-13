package com.wanted.preonboarding.theater.service.handler;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TicketSeller {
    private final TicketOffice ticketOffice;

    public void checkTicket(Audience audience) {
        if (audience.getBag().hasInvitation()) {
            ticketOffice.changeTicket(audience);
        } else {
            ticketOffice.sellTicket(audience);
        }
    }
}
