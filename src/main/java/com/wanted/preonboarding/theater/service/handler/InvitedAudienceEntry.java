package com.wanted.preonboarding.theater.service.handler;

import org.springframework.stereotype.Component;

import static com.wanted.preonboarding.theater.service.handler.AudienceState.INVITED;

@Component
public class InvitedAudienceEntry implements EntryStrategy {

    @Override
    public boolean isTargetAudience(AudienceState state) {

        return state == INVITED;
    }

    @Override
    public void enter(Audience audience, TicketSeller ticketSeller) {

        Ticket ticket = ticketSeller.takeOutTicket();
        audience.takeTicket(ticket);
    }

}
