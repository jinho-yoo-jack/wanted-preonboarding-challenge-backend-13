package com.wanted.preonboarding.theater.service;

import com.wanted.preonboarding.theater.dto.RequestMessage;
import com.wanted.preonboarding.theater.service.handler.Audience;
import com.wanted.preonboarding.theater.service.handler.Bag;
import com.wanted.preonboarding.theater.service.handler.Theater;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TheaterService {
    private final Theater theater;

    public String enter(RequestMessage requestMessage) {
        Audience audience = createAudience(requestMessage);
        return theater.enter(audience)? "Have a good time." : "I'm sorry, but entering inside might not be possible.";
    }

    private Audience createAudience(RequestMessage requestMessage) {
        return new Audience(new Bag(requestMessage));
    }
}
