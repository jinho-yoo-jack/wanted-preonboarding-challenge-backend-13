package com.wanted.preonboarding.theater.service.handler;

import lombok.AllArgsConstructor;

/**
 * 티켓 판매 클래스
 */
@AllArgsConstructor
public class TicketSeller {
    private final TicketOffice ticketOffice;

    public boolean checkTicket(Audience audience) {
        // 티켓이 있을 경우
        if (audience.getBag().hasTicket()) return true;

        Ticket ticket = ticketOffice.getTicket();

        // 초대장이 있을 경우
        if (audience.getBag().hasInvitation()) {
            audience.getBag().setTicket(ticket);
            return true;
        }

        // 초대장이 없을 경우
        return sellTicket(audience, ticket);
    }

    private boolean sellTicket(Audience audience, Ticket ticket) {
        // 관객이 가진 돈이 티켓 가격보다 적을 경우
        if (audience.getBag().getAmount() < ticket.getFee()) return false;

        audience.getBag().minusAmount(ticket.getFee());
        ticketOffice.plusAmount(ticket.getFee());
        audience.getBag().setTicket(ticket);

        return true;
    }
}
