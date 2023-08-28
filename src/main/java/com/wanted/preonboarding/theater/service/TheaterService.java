package com.wanted.preonboarding.theater.service;

import com.wanted.preonboarding.theater.service.handler.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.wanted.preonboarding.theater.service.model.*;

@Service
@RequiredArgsConstructor
public class TheaterService {
    private final Theater theater;

    public String enter(RequestMessage requestMessage) {
        Audience audience = Audience.of(requestMessage);
        Ticket ticket = new Ticket(requestMessage.getFee());
        return theater.enter(audience, ticket);
    }
}
