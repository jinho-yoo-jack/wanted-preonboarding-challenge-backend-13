package com.wanted.preonboarding.theater.service;

import com.wanted.preonboarding.theater.domain.*;
import com.wanted.preonboarding.theater.dto.AudienceRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TheaterService {
    private final Theater theater;
    private static final TicketSeller ticketSeller = new TicketSeller(new TicketOffice(20000L, new Ticket(100L)));

    public String enter(AudienceRequest audienceRequest) {
        theater.enter(Audience.of(audienceRequest), ticketSeller);
        return "Have a good time.";
    }
}
