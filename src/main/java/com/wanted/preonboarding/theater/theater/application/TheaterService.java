package com.wanted.preonboarding.theater.theater.application;

import com.wanted.preonboarding.theater.audience.application.AudienceService;
import com.wanted.preonboarding.theater.audience.domain.Audience;
import com.wanted.preonboarding.theater.audience.domain.Bag;
import com.wanted.preonboarding.theater.theater.application.dto.RequestMessage;
import com.wanted.preonboarding.theater.theater.domain.Theater;
import com.wanted.preonboarding.theater.ticket.application.TicketSeller;
import com.wanted.preonboarding.theater.ticket.application.TicketService;
import com.wanted.preonboarding.theater.ticket.domain.Ticket;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TheaterService {
    private final TicketService ticketService;
    private final TicketSeller ticketSeller;
    private final AudienceService audienceService;

    public String enter() {
        Bag bag = new Bag(1000L);
        Audience audience = new Audience(bag);
        Ticket ticket = new Ticket(100L);

        enter(audience, ticketSeller);
        return "Have a good time.";
    }

    public String enter(RequestMessage request) {
        final Long audienceId = request.getAudienceId();
        final Long ticketId = request.getTicketId();
        Audience audience = audienceService.findById(audienceId);
        Ticket ticket = ticketService.findById(ticketId);
        Theater theater = new Theater(audience, ticket, ticketSeller);

        theater.enter();
        return "Have a good time.";
    }

    private void enter(Audience audience, TicketSeller ticketSeller) {
        if (audience.getBag().hasInvitation()) {
            Ticket ticket = ticketSeller.getTicket(1L);
            audience.putTicketInBag(ticket);
        } else {
            Ticket ticket = ticketSeller.getTicket(1L);
            final Long fee = ticket.getFee();
            audience.dischargeAmount(fee);
            ticketSeller.chargeAmount(fee);
            audience.putTicketInBag(ticket);
        }
    }
}
