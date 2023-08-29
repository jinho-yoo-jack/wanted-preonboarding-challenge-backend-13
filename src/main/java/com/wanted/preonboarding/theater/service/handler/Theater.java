package com.wanted.preonboarding.theater.service.handler;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Theater {

    // 관람객의 예매권을 확인하고,
    // 1. 예매권이 있으면, 해당 예매권을 티켓으로 바꿔서 티켓을 지급한다.
    // 2. 예매권이 없으면, 바로 티켓을 구매해서 입장한다.
    public void enter(Audience audience, TicketSeller ticketSeller){
        if(audience.hasInvitation()){
            ticketSeller.giveTicketTo(audience);
        }else {
            ticketSeller.sellTicketTo(audience);
        }
    }
}
