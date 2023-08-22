package com.wanted.preonboarding.theater.service;

import com.wanted.preonboarding.theater.service.handler.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class TheaterService {

    private final Theater theater;

    public String enter(Audience audience){

        TicketSeller ticketSeller = new TicketSeller(new TicketOffice(20000L, new Ticket(100L)));
        theater.enter(audience, ticketSeller);

        log.info("audience={}", audience);
        log.info("ticketSeller={}", ticketSeller);

        return "Have a good time.";
    }
}
