package com.wanted.preonboarding.theater.service;

import com.wanted.preonboarding.theater.service.handler.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class TheaterService {
    private final Theater theater;
    public String enter(Audience audience){
        TicketSeller ticketSeller = new TicketSeller(new TicketOffice(20000L, new Ticket(1000L)));
        Ticket ticket = ticketSeller.publishTicket();
        if (!audience.hasInvitation()) {
            audience.minusAmount(ticket.getFee());
            ticketSeller.addAmount(ticket.getFee());
        }
        audience.setTicket(ticket);
        theater.enter(audience);
        return "Have a good time.";
    }
}
