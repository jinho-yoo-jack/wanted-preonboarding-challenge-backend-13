package com.wanted.preonboarding.theater.service;

import com.wanted.preonboarding.theater.dto.RequestMessage;
import com.wanted.preonboarding.theater.service.handler.Audience;
import com.wanted.preonboarding.theater.service.handler.Theater;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TheaterService {

    private final Theater theater;

    public String enter(RequestMessage requestMessage) {
        Audience audience = Audience.of(requestMessage);
        theater.enter(audience);
        return "Have a good time.";
    }
}
