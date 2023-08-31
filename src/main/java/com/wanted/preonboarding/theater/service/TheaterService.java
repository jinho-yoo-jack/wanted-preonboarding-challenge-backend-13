package com.wanted.preonboarding.theater.service;

import com.wanted.preonboarding.theater.dto.RequestMessage;
import com.wanted.preonboarding.theater.service.handler.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TheaterService {
    private final Theater theater;

    public String enter(RequestMessage request){
        Audience audience = new Audience(Bag.of(request.getAmount(), request.getInvitationAt()));

        theater.enter(audience);
        return "Have a good time.";
    }
}
