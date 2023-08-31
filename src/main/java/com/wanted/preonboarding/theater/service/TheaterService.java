package com.wanted.preonboarding.theater.service;

import com.wanted.preonboarding.theater.service.handler.*;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Builder
@Service
@RequiredArgsConstructor
public class TheaterService {

    private final Theater theater;

    private static final Long TICKET_FEE = 100L;
    private static final Long TICKET_OFFICE_AMOUNT = 20000L;
    
    public String enter(Audience audience){
        log.info("TheaterService.enter: {}", audience);

        List<Ticket> list = new ArrayList<>();
        Ticket ticket = Ticket.builder()
                .fee(TICKET_FEE)
                .build();
        list.add(ticket);

        TicketOffice ticketOffice = TicketOffice.builder()
                .amount(TICKET_OFFICE_AMOUNT)
                .tickets(list)
                .build();

        TicketSeller ticketSeller = TicketSeller.builder()
                .ticketOffice(ticketOffice)
                .build();

        Bag bag = audience.getBag();
        if(!bag.hasInvitation()){
            log.info("Audience has no ticket.");
            bag.minusAmount(ticket.getFee());
            ticketOffice.plusAmount(ticket.getFee());
        }

        theater.enter(audience, ticketSeller);

        return "Have a good time.";
    }
}
