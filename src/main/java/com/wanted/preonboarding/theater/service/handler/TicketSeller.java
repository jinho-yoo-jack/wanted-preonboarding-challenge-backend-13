package com.wanted.preonboarding.theater.service.handler;

import org.springframework.util.Assert;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class TicketSeller {
    private final TicketOffice ticketOffice;

    public void sellTicketsTo(Audience audience) {
        Assert.notNull(audience, "Audience is required.");

        Ticket ticket = ticketOffice.getTicket();
        if (audience.hasInvitation()) {
            audience.exchangeFor(ticket);
            log.info("Exchange invitation for tickets.");
        } else {
            audience.buy(ticket);
            ticketOffice.plusAmount(ticket.getFee());
            log.info("Buy a ticket.");
        }
    }
}
