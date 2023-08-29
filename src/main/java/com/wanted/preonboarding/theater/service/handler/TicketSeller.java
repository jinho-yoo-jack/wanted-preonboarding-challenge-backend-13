package com.wanted.preonboarding.theater.service.handler;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TicketSeller {
    private final TicketOffice ticketOffice;

    public void sellTo(Audience audience) {
        long paidTicketFee = audience.buy(ticketOffice.getTicket());
        ticketOffice.getPaid(paidTicketFee);
    }
}
