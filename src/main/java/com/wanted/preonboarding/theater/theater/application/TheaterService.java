package com.wanted.preonboarding.theater.theater.application;

import com.wanted.preonboarding.theater.audience.application.AudienceService;
import com.wanted.preonboarding.theater.audience.domain.Audience;
import com.wanted.preonboarding.theater.audience.domain.Bag;
import com.wanted.preonboarding.theater.theater.application.dto.RequestMessage;
import com.wanted.preonboarding.theater.theater.domain.TicketSeller;
import com.wanted.preonboarding.theater.ticket.application.TicketOffice;
import com.wanted.preonboarding.theater.ticket.application.TicketService;
import com.wanted.preonboarding.theater.ticket.domain.Ticket;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TheaterService { // TicketSeller
    private final TicketService ticketService;
    private final TicketOffice ticketOffice;
    private final AudienceService audienceService;

    public String enter(RequestMessage request) {
        final Long audienceId = request.getAudienceId();
        final Long ticketId = request.getTicketId();

        Audience audience = audienceService.findById(audienceId);
        Ticket ticket = ticketService.findById(ticketId);

        TicketSeller ticketSeller = new TicketSeller(audience, ticket, ticketOffice);
        ticketSeller.sellTicket();

        return "Have a good time.";
    }
}
