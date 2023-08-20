package com.wanted.preonboarding.theater.service;

import com.wanted.preonboarding.theater.dto.RequestMessage;
import com.wanted.preonboarding.theater.service.handler.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TheaterService {
    private final Theater theater;

    public String enter(final RequestMessage requestMessage){
        theater.enter(new Audience(new Bag(1000L)),
                new TicketSeller(new TicketOffice(requestMessage.getAmount(), new Ticket(requestMessage.getTicketFee()))));
        return "Have a good time.";

    }
}
