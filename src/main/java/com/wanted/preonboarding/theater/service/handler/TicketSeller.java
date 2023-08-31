package com.wanted.preonboarding.theater.service.handler;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TicketSeller {
    private final TicketOffice ticketOffice;

    public boolean checkTicket(Audience audience) {
        if (audience.getBag().hasInvitation()) {
            ticketOffice.changeTicket(audience);
            return true;
        } else {
            return ticketOffice.sellTicket(audience);
        }
    }
}
