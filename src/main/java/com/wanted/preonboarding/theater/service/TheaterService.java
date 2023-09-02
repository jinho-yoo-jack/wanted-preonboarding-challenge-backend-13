package com.wanted.preonboarding.theater.service;

import com.wanted.preonboarding.theater.domain.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TheaterService {
    private final Theater theater;

    public String enter(Bag bag) {
        theater.enter(new Audience(bag),
                new TicketSeller(new TicketOffice(20000L, new Ticket(100L))));
        return "Have a good time.";
    }
}
