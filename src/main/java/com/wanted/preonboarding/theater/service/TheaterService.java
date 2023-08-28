package com.wanted.preonboarding.theater.service;

import com.wanted.preonboarding.theater.service.handler.*;
import com.wanted.preonboarding.theater.service.handler.dto.RequestMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TheaterService {
    private final Theater theater;

    public String enter(RequestMessage request){

        theater.enter(new Audience(Bag.createBag(request)), new TicketSeller(new TicketOffice(20000L, new Ticket(1000L))));
        return "Have a good time.";
    }
}
