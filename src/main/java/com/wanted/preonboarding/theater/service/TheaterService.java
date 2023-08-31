package com.wanted.preonboarding.theater.service;

import com.wanted.preonboarding.theater.dto.request.EnterTheaterRequest;
import com.wanted.preonboarding.theater.exception.NotEnoughAmountException;
import com.wanted.preonboarding.theater.service.handler.Theater;
import com.wanted.preonboarding.theater.service.handler.consumer.Audience;
import com.wanted.preonboarding.theater.service.handler.consumer.Consumer;
import com.wanted.preonboarding.theater.service.handler.seller.Seller;
import com.wanted.preonboarding.theater.service.handler.seller.Ticket;
import com.wanted.preonboarding.theater.service.handler.seller.TicketOffice;
import com.wanted.preonboarding.theater.service.handler.seller.TicketSeller;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TheaterService {
    private final Theater theater;

    public String enter(EnterTheaterRequest enterTheaterRequest){
        TicketSeller seller = TicketSeller.builder()
                .ticketOffice(new TicketOffice(20000L, new Ticket(100L)))
                .build();
        try {
            theater.enter(Audience.of(enterTheaterRequest), seller);
            return "Have a good time.";
        } catch (NotEnoughAmountException e) {
            return e.getMessage();
        }
    }
}
