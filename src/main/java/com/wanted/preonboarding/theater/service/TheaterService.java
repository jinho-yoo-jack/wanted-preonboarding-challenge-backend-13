package com.wanted.preonboarding.theater.service;

import com.wanted.preonboarding.theater.RequestMessage;
import com.wanted.preonboarding.theater.domain.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TheaterService {
    private final Theater theater;
    private final TicketSeller ticketSeller;

    public String enter(RequestMessage message){
        Ticket ticket = null;
        Invitation invitation = null;
        if (message.isInvitation()) {
            invitation = new Invitation();
        }
        if (message.hasTicket()) {
            ticket = new Ticket(0L);
        }

        Audience audience = new Audience(new Bag(invitation, ticket, message.backInMoney()));
        theater.enter(audience, ticketSeller);

        return "Have a good time.";
    }
}
