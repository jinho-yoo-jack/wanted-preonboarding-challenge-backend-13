package com.wanted.preonboarding.theater.service;

import com.wanted.preonboarding.theater.service.handler.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TheaterService {
    private final Theater theater;

    public String enter(Audience audience) {
        if (theater.enter(audience)) {
            return "Have a good time.";
        } else {
            return "You are not allowed to enter.";
        }

    }
}
