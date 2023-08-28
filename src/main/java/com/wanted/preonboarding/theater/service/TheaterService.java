package com.wanted.preonboarding.theater.service;

import com.wanted.preonboarding.theater.dto.AudienceRequestDto;
import com.wanted.preonboarding.theater.service.handler.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TheaterService {
    private final Theater theater;

    public String enter(AudienceRequestDto audienceRequestDto){
        Bag audienceBag = Bag.builder()
                .amount(audienceRequestDto.getAmount())
                .invitation(audienceRequestDto.isInvitation() ? new Invitation() : null)
                .build();

        Audience audience = Audience.builder()
                .bag(audienceBag)
                .build();

        theater.enter(audience,
                new TicketSeller(new TicketOffice(20000L, new Ticket(100L))));

        return "Have a good time.";
    }
}
