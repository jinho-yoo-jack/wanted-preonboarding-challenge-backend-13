package com.wanted.preonboarding.theater.service;

import com.wanted.preonboarding.theater.service.dto.TheaterEnterRequestDto;
import com.wanted.preonboarding.theater.service.handler.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class TheaterService {
    private final Theater theater;

    public String enter(){
        theater.enter(new Audience(new Bag(1000L)),
                new TicketSeller(new TicketOffice(20000L, new Ticket(100L))));
        return "Have a good time.";

    }

    public String enter(TheaterEnterRequestDto enterRequestDto) {
        Audience audience = new Audience(enterRequestDto.toBag());
        TicketSeller ticketSeller = new TicketSeller(new TicketOffice(20000L, new Ticket(100L)));

        theater.enter(audience, ticketSeller);

        return "Have a good time.";
    }
}
