package com.wanted.preonboarding.theater.service;

import com.wanted.preonboarding.theater.service.handler.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TheaterService {
    private final Theater theater;
    private final TicketSeller ticketSeller = new TicketSeller(new TicketOffice(20000L, new Ticket(100L)));

    public String enter(Audience audience) {
        theater.enter(audience, ticketSeller);
        return "Have a good time.";
    }
}
