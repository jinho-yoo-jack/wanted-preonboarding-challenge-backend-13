package com.wanted.preonboarding.theater.theater;

import com.wanted.preonboarding.theater.audience.application.AudienceService;
import com.wanted.preonboarding.theater.audience.domain.Audience;
import com.wanted.preonboarding.theater.audience.domain.Bag;
import com.wanted.preonboarding.theater.theater.domain.Theater;
import com.wanted.preonboarding.theater.ticket.application.dto.RequestMessage;
import com.wanted.preonboarding.theater.ticket.domain.Ticket;
import com.wanted.preonboarding.theater.ticket.domain.TicketOffice;
import com.wanted.preonboarding.theater.ticket.domain.TicketSeller;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TheaterService {
    private final Theater theater;

    public String enter() {
        Bag bag = new Bag(1000L);
        Audience audience = new Audience(bag);
        Ticket ticket = new Ticket(100L);

        TicketOffice ticketOffice = new TicketOffice(20000L, ticket);
        TicketSeller ticketSeller = new TicketSeller(ticketOffice);

        theater.enter(audience, ticketSeller);
        return "Have a good time.";
    }

    public String enter(RequestMessage request) {
        return "Have a good time.";
    }
}
