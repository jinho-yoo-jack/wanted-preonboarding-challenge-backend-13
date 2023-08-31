package com.wanted.preonboarding.theater.service.handler;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class Theater {
    public void enter(Audience audience, TicketSeller ticketSeller){
        if (hasTicket(audience))
            return;

        Ticket ticket = getAvailableTicket(ticketSeller);
        TicketOffice ticketOffice = ticketSeller.getTicketOffice();

        if (hasInvitation(audience)) {
            exchangeInvitationWithTicket(ticket, ticketOffice);
        } else
            sellTicket(ticket, audience.getBag(), ticketOffice);

        audience.getBag().setTicket(ticket);
    }

    private static boolean hasTicket(Audience audience) {
        return audience.getBag().hasTicket();
    }

    private static boolean hasInvitation(Audience audience) {
        return audience.getBag().hasInvitation();
    }

    private static void exchangeInvitationWithTicket(Ticket ticket, TicketOffice ticketOffice) {
        log.info("초대장과 티켓 교환");
        ticketOffice.exchangeInvitationWithTicket(ticket);
    }

    private static void sellTicket(Ticket ticket, Bag bag, TicketOffice ticketOffice) {
        log.info("티켓 판매 ({}원)", ticket.getFee());
        bag.minusAmount(ticket.getFee());
        ticketOffice.sellTicket(ticket);
    }

    private static Ticket getAvailableTicket(TicketSeller ticketSeller) {
        return ticketSeller.getTicketOffice().getTicket();
    }
}
