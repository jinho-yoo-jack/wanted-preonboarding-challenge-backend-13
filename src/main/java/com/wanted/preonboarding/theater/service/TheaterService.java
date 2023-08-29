package com.wanted.preonboarding.theater.service;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.wanted.preonboarding.theater.dto.AudienceEnterDTO;
import com.wanted.preonboarding.theater.service.handler.Audience;
import com.wanted.preonboarding.theater.service.handler.Theater;
import com.wanted.preonboarding.theater.service.handler.Ticket;
import com.wanted.preonboarding.theater.service.handler.TicketOffice;
import com.wanted.preonboarding.theater.service.handler.TicketSeller;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TheaterService {
    private final Theater theater;

    public String enter(AudienceEnterDTO enterDTO){
        Assert.notNull(enterDTO, "TheaterEnterDTO is required.");

        Audience audience = enterDTO.toAudience();
        TicketSeller ticketSeller = new TicketSeller(new TicketOffice(2000L, new Ticket(100L)));

        theater.enter(audience, ticketSeller);
        return "Have a good time.";
    }
}
