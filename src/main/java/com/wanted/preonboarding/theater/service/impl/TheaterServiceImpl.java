package com.wanted.preonboarding.theater.service.impl;

import com.wanted.preonboarding.theater.dto.request.RequestMessage;
import com.wanted.preonboarding.theater.exception.NotEnoughAmountException;
import com.wanted.preonboarding.theater.service.TheaterService;
import com.wanted.preonboarding.theater.service.TicketOffice;
import com.wanted.preonboarding.theater.service.handler.Audience;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TheaterServiceImpl implements TheaterService {
    private final TicketOffice ticketOffice;
    @Override
    public String enter(RequestMessage requestMessage) throws NotEnoughAmountException {
        Audience audience = new Audience(requestMessage);
        if(!audience.hasInvitation()) {
            buyTicket(audience, ticketOffice.getTicket().getFee());
        }
        audience.setTicket(ticketOffice.getTicket());
        return "Have a good time.";

    }

    private void buyTicket(Audience audience, Long ticketFee) throws NotEnoughAmountException {
        audience.minusAmount(ticketFee);
        ticketOffice.plusAmount(ticketFee);
    }
}
