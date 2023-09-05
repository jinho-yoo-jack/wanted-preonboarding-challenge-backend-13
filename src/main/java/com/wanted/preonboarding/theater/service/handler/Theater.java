package com.wanted.preonboarding.theater.service.handler;

import lombok.Getter;
import lombok.RequiredArgsConstructor;


@Getter
@RequiredArgsConstructor
public class Theater {

    private final TicketOffice ticketOffice;

    public String enterSuccess(Audience audience) {
        return "Have a good time " + audience.getName()+ ".";
    }
}
