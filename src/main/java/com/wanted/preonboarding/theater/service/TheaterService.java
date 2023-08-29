package com.wanted.preonboarding.theater.service;

import com.wanted.preonboarding.theater.service.handler.RequestMessage;
import com.wanted.preonboarding.theater.service.handler.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TheaterService {
    private final Theater theater;

    private final Long seller_init_amount = 10000L;

    private final Long ticket_price = 8000L;
    public String enter(RequestMessage message){
        /** 관객과 판매업체 각각 생성
         *
         * 관객은 입력값에 따라 다르게
         * 판매업체는 고정된값 사용
         */
        Audience audience = new Audience(new Bag(message.getAudience_amount(), new Invitation(message.getTime())));
        TicketSeller ticketSeller = new TicketSeller(new TicketOffice(seller_init_amount,new Ticket(ticket_price)));

        theater.enter(audience,ticketSeller);
        return "ok";
    }
}

