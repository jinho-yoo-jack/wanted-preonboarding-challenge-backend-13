package com.wanted.preonboarding.theater.service.handler;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Theater {

    public void enter(Audience audience, TicketSeller ticketSeller){
        // 초대장이 있으면 요금 지불 필요 없음
        // 초대장이 없으면 ticketSeller에게 ticket 요금 지불
        Ticket ticket = ticketSeller.issueTicket();
        Long fee = audience.buyTicket(ticket);
        ticketSeller.deposit(fee);
    }
}
