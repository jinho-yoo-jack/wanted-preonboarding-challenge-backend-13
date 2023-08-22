package com.wanted.preonboarding.theater.service.handler;

public interface EntryStrategy {

    boolean isTargetAudience(AudienceState audienceState);

    void enter(Audience audience, TicketSeller ticketSeller);

}
