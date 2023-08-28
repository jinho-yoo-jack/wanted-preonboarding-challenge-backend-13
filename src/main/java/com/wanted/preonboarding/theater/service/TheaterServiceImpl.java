package com.wanted.preonboarding.theater.service;

import com.wanted.preonboarding.theater.dto.RequestMessage;
import com.wanted.preonboarding.theater.service.handler.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TheaterServiceImpl implements TheaterService {

    private final Theater theater;

    public String enter(RequestMessage requestMessage) {
        theater.enter(new Audience(requestMessage),
            new TicketSeller(new TicketOffice(20000L, new Ticket(requestMessage.getTicketFee()))));
        return "Have a good time.";

    }
}
