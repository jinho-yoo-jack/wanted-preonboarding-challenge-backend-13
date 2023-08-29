package com.wanted.preonboarding.theater.service;

import com.wanted.preonboarding.theater.service.dto.TheaterEnterRequestDto;
import com.wanted.preonboarding.theater.service.handler.*;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TheaterService {
    private final Theater theater;

    public String enter(TheaterEnterRequestDto enterRequestDto) {
        Audience audience = new Audience(enterRequestDto.toBag());
        TicketSeller ticketSeller = new TicketSeller(new TicketOffice(20000L, new Ticket(100L)));

        theater.enter(audience, ticketSeller);

        return "Have a good time.";
    }
}
