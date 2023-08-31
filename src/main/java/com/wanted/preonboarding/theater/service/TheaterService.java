package com.wanted.preonboarding.theater.service;

import com.wanted.preonboarding.theater.service.handler.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class TheaterService {

    public String enter(Audience audience){

        TicketSeller ticketSeller = new TicketSeller(new TicketOffice(20000L, new Ticket(100L)));

        if(audience.getBag().hasInvitation()){
            log.info("초대를 받은 관객입니다.");
            Ticket ticket = ticketSeller.getTicketOffice().getTicket();
            audience.getBag().setTicket(ticket);

        }else { // 초대받은 날짜 자체가 없으면 티켓이 없는 것으로 간주
            log.info("초대받지 않은 관객입니다.");
            Ticket ticket = ticketSeller.getTicketOffice().getTicket();

            // 티켓 구매에 따른 잔고 처리
            audience.getBag().minusAmount(ticket.getFee());
            ticketSeller.getTicketOffice().plusAmount(ticket.getFee());

            audience.getBag().setTicket(ticket);
        }

        // 입장
        return "Have a good time.";
    }
}
