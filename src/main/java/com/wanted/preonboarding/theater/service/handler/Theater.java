package com.wanted.preonboarding.theater.service.handler;

import com.wanted.preonboarding.theater.dto.AudienceDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Theater {

    private final TicketSeller ticketSeller;

    public Ticket check() {
        return ticketSeller.getTicketOffice().getTicket();
    }
    public AudienceDto sell(AudienceDto audience, Ticket ticket) {
        Long price = ticket.getFee(); // 티켓 가격
        audience.setAmount(audience.getAmount()-price);
        ticketSeller.getTicketOffice().plusAmount(price);
        return audience;
    }

    public AudienceDto ticketing(AudienceDto audience){
        audience.setTicket(true);
        return audience;
    }
}