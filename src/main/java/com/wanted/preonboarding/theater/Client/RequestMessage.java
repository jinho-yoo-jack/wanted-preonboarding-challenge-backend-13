package com.wanted.preonboarding.theater.Client;

import com.wanted.preonboarding.theater.service.handler.Audience;
import com.wanted.preonboarding.theater.service.handler.TicketOffice;

public class RequestMessage {
    private Audience audience;
    private TicketOffice ticketOffice;

    public RequestMessage(Audience audience, TicketOffice office) {
        this.audience = audience;
        this.ticketOffice = office;
    }

    public Audience getAudience() { return this.audience; }
    public TicketOffice getTicketOffice() { return this.ticketOffice; }
}
