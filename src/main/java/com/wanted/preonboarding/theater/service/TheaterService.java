package com.wanted.preonboarding.theater.service;


import com.wanted.preonboarding.theater.service.handler.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
@RequiredArgsConstructor
public class TheaterService {
    private final Theater theater;

    public boolean enter(Long amount, LocalDateTime invitationDate) {
        try {
            Audience audience = createAudience(amount, invitationDate);
            TicketSeller ticketSeller = new TicketSeller(new TicketOffice(20000L, new Ticket(100L)));
            theater.enter(audience, ticketSeller);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private Audience createAudience(Long amount, LocalDateTime invitationDate) {
        Bag bag;
        if (invitationDate!=null){
            Invitation invitation = new Invitation(invitationDate);
            bag = new Bag(invitation, amount);
        } else {
            bag = new Bag(amount);
        }
        return new Audience(bag);
    }

}
