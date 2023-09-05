package com.wanted.preonboarding.theater.service;

import com.wanted.preonboarding.theater.service.handler.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TheaterService {

    private final Theater theater;

    public String enter() {
        theater.enter(new Audience(new Bag(1000L)));
        return "Have a good time.";

    }
}
