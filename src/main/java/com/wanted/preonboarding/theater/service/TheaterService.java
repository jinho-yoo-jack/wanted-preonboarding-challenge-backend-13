package com.wanted.preonboarding.theater.service;

import com.wanted.preonboarding.theater.domain.AudienceRequestDto;
import com.wanted.preonboarding.theater.service.handler.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TheaterService {
    private final Theater theater;

    public String enter(AudienceRequestDto audienceRequestDto){
        Audience audience = new Audience(audienceRequestDto);
        theater.enter(audience);
        return "Have a good time.";

    }
}
