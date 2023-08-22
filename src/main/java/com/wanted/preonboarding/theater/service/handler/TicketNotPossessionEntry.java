package com.wanted.preonboarding.theater.service.handler;

import org.springframework.stereotype.Component;

import static com.wanted.preonboarding.theater.service.handler.AudienceState.TICKET_NOT_POSSESSION;

@Component
public class TicketNotPossessionEntry implements EntryStrategy {

    @Override
    public boolean isTargetAudience(AudienceState state) {

        return state == TICKET_NOT_POSSESSION;
    }

    @Override
    public void enter(Audience audience, TicketSeller ticketSeller) {

        audience.buyTicket(ticketSeller);
    }

}
