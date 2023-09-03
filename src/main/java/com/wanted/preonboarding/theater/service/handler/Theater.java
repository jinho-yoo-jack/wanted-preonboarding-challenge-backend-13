package com.wanted.preonboarding.theater.service.handler;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class Theater {

    private final TicketSeller ticketSeller=new TicketSeller(new TicketOffice(20000L, new Ticket(100L)));


    public Boolean enter(Audience audience){
        if(audience.hasInvitation()){
            ticketSeller.giveTicketTo(audience);
            log.info("초대권 보유");
            return true;
        }
        if(audience.payFeeTo(ticketSeller)){
            ticketSeller.giveTicketTo(audience);
            log.info("초대권 미보유");
            return true;
        }else{
            log.info("보유금 부족");
            return false;
        }
    }
}
