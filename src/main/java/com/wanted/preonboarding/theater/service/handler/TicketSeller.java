package com.wanted.preonboarding.theater.service.handler;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TicketSeller {

    private final TicketOffice ticketOffice;

    public void sellTo(Audience audience) {
        Long paidAmount = audience.buy(ticketOffice.getTicket());
        ticketOffice.plusAmount(paidAmount);
    }

}
