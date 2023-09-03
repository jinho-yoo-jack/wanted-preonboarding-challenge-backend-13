package com.wanted.preonboarding.theater.service;

import com.wanted.preonboarding.theater.dto.AudienceRequestDto;
import com.wanted.preonboarding.theater.entity.Audience;
import com.wanted.preonboarding.theater.handler.TicketSeller;
import com.wanted.preonboarding.theater.handler.Theater;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TheaterService {
    private final Theater theater;

    public String enter(AudienceRequestDto dto) {
        theater.enter(Audience.of(dto));

        return "Have a good time.";
    }
}
