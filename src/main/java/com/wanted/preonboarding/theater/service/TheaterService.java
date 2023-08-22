package com.wanted.preonboarding.theater.service;

import com.wanted.preonboarding.theater.dto.TheaterRequest;
import com.wanted.preonboarding.theater.dto.TheaterResponse;
import com.wanted.preonboarding.theater.service.handler.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TheaterService {
    private final Theater theater;

    public TheaterResponse.Enter enter(TheaterRequest.Audience request){
        Audience audience = createAudience(request); // 고객 생성
        TicketSeller ticketSeller = createTicketSeller(); // 티켓 판매자 생성

        return theater.enter(audience, ticketSeller);
    }

    private Audience createAudience(TheaterRequest.Audience request) {
        Invitation invitation = Invitation.create(request.getInvitationDateTime());
        long amount = request.getAmount() != null ? request.getAmount() : 0L;
        Bag bag = new Bag(invitation, amount);
        return new Audience(bag);
    }

    private TicketSeller createTicketSeller() {
        Ticket ticket = new Ticket(100L);
        TicketOffice ticketOffice = new TicketOffice(20000L, ticket);
        return new TicketSeller(ticketOffice);
    }
}
