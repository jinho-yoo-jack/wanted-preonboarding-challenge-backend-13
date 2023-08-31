package com.wanted.preonboarding.theater.service.handler;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TicketSeller {
    private final TicketOffice ticketOffice;

    public Ticket issueTicketTo(Audience audience) {
        Ticket ticket = ticketOffice.getTicket();
        if (!audience.hasInvitation()) {
            // 초대권이 없으면 티켓 판매
            audience.pay(ticket.getFee());
            ticketOffice.plusAmount(ticket.getFee());
        }

        return ticket;
    }
}
