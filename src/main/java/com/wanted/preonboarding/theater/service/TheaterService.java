package com.wanted.preonboarding.theater.service;

import com.wanted.preonboarding.theater.entity.Bag;
import com.wanted.preonboarding.theater.entity.TicketOffice;
import com.wanted.preonboarding.theater.entity.TicketSeller;
import com.wanted.preonboarding.theater.handler.Theater;
import com.wanted.preonboarding.theater.entity.Audience;
import com.wanted.preonboarding.theater.entity.baseEntity.Ticket;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TheaterService {
    private final Theater theater;

    public String enter(){
        theater.enter(new Audience(new Bag(1000L)),
                new TicketSeller(new TicketOffice(20000L, new Ticket(100L))));
        return "Have a good time.";

    }
}
