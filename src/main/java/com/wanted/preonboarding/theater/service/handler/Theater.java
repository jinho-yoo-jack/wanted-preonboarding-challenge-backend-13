package com.wanted.preonboarding.theater.service.handler;

import com.wanted.preonboarding.theater.entity.Audience;
import com.wanted.preonboarding.theater.entity.TicketSeller;
import org.springframework.stereotype.Component;

@Component
public interface Theater {

    void enter(Audience audience, TicketSeller ticketSeller);
}
