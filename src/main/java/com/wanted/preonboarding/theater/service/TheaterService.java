package com.wanted.preonboarding.theater.service;

import com.wanted.preonboarding.theater.service.handler.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TheaterService {
    public final static String ENTER_MESSAGE = "Have a good time.";

    private final Theater theater;

    public String enter(){
        theater.enter(new Audience(new Bag(1000L)),
                new TicketSeller(new TicketOffice(20000L, new Ticket(100L))));
        return ENTER_MESSAGE;

    }
}
