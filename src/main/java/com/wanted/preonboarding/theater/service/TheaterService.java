package com.wanted.preonboarding.theater.service;

import com.wanted.preonboarding.theater.service.handler.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TheaterService {
    public final static String ENTER_MESSAGE = "Have a good time.";

    private final Theater theater;

    public String enter(long amount, boolean doesHaveInvitation) {
        Audience audience = createAudience(amount, doesHaveInvitation);
        theater.enter(audience, new TicketSeller(new TicketOffice(20000L, new Ticket(100L))));
        return ENTER_MESSAGE;

    }

    private Audience createAudience(long amount, boolean doesHaveInvitation) {
        if (doesHaveInvitation) {
            return new Audience(new Bag(new Invitation(), amount));
        }
        return new Audience(new Bag(amount));
    }
}
