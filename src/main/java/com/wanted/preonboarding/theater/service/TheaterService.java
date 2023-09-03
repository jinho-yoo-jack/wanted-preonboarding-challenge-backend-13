package com.wanted.preonboarding.theater.service;

import com.wanted.preonboarding.theater.domain.Bag;
import com.wanted.preonboarding.theater.domain.Theater;
import com.wanted.preonboarding.theater.domain.Ticket;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TheaterService {
    private final Theater theater;

    public String enter(Bag bag) {
        Ticket ticket;

        if (theater.invitationCheck(bag)) {
            ticket = theater.ticketOfficeGuide();
        } else {
            ticket = theater.ticketOfficeGuide(bag.pay(theater.getShowFee()));
        }

        bag.acquireTicket(ticket);

        if (!bag.hasTicket()) {
            throw new RuntimeException();
        }

        return theater.enter(bag.presentTicket());
    }
}
