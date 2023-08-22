package com.wanted.preonboarding.theater.service.handler;

import org.springframework.stereotype.Component;

import static com.wanted.preonboarding.theater.service.handler.AudienceState.TICKET_POSSESSION;

@Component
public class TicketPossessionEntry implements EntryStrategy {

    @Override
    public boolean isTargetAudience(AudienceState state) {

        return state == TICKET_POSSESSION;
    }

    @Override
    public void enter(Audience audience, TicketSeller ticketSeller) {
        // 그냥 입장한다.
    }

}
