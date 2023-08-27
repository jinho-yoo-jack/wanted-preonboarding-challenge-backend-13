package com.wanted.preonboarding.theater.service;

import com.wanted.preonboarding.audience.enums.AdmissionType;
import com.wanted.preonboarding.audience.service.handler.Audience;
import com.wanted.preonboarding.audience.service.handler.Bag;
import com.wanted.preonboarding.theater.service.handler.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.wanted.preonboarding.audience.enums.AdmissionType.DENIED;
import static com.wanted.preonboarding.audience.enums.AdmissionType.ENTER;

@Service
@RequiredArgsConstructor
public class TheaterService {
    private final Theater theater;
    private final TicketService ticketService;

    public String enter(){
        Audience audience = new Audience(new Bag(1000L));
        TicketOffice ticketOffice = TicketOffice.createTicketOffice(20000L, new Ticket(100L));
        TicketSeller ticketSeller = TicketSeller.createTicketSeller(ticketOffice);

        AdmissionType admissionType = ticketService.canEnter(audience);
        if (admissionType == DENIED) {
            Ticket ticket = ticketSeller.sellTicket();
            audience.buy(ticket);
        }

        if (admissionType == ENTER) {
            Ticket ticket = ticketSeller.getTicketOffice().getTicket();
            audience.getBag().setTicket(ticket);
        }

        theater.enter(audience);
        return "Have a good time.";

    }
}
