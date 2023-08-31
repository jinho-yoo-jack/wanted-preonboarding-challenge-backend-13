package com.wanted.preonboarding.theater.service;

import com.wanted.preonboarding.theater.service.dto.AudienceTicketPurchaseDto;
import com.wanted.preonboarding.theater.service.handler.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class TheaterService {
    private final Theater theater;
    private final Environment env;
    private final TicketProperties ticketProperties;
    private final TicketOfficeProperties ticketOfficeProperties;

    public String enter(final AudienceTicketPurchaseDto dto){
        Audience audience = Audience.from(Bag.of(dto.getInvitation(), dto.getAmount()));
        TicketOffice ticketOffice = new TicketOffice(
                ticketOfficeProperties.getAmount(),
                Ticket.create(ticketProperties.getFee()));
        TicketSeller ticketSeller = new TicketSeller(ticketOffice);

        theater.enter(audience, ticketSeller);
        return "Have a good time.";
    }

}
