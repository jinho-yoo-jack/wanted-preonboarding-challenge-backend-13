package com.wanted.preonboarding.theater.service.handler;

import com.wanted.preonboarding.exception.NotAllowedAudienceException;
import com.wanted.preonboarding.theater.entity.Audience;
import com.wanted.preonboarding.theater.entity.Ticket;
import com.wanted.preonboarding.theater.entity.TicketSeller;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class TicketTheaterImpl implements Theater {
    public void enter(Audience audience, TicketSeller ticketSeller)
            throws NotAllowedAudienceException {
            // 소지권이 없다면 티켓 발급
            Ticket ticket = ticketSeller.getTicketOffice().getTicket();
            Long amount = audience.getBag().getAmount();
            Long fee = ticket.getFee();

            // Ticket fee 보다 Audience amount 작다면 예외처리
            if( amount < fee ){
                /*throw NotAllowedAudienceException
                        .builder()
                        .status(HttpStatus.BAD_REQUEST)
                        .errMessage("fee금액인 "+fee+"보다 입력금액인 " + amount + " 이(가) 작습니다.")
                        .build();*/
                throw new NotAllowedAudienceException(HttpStatus.BAD_REQUEST,
                        "fee금액인 "+fee+"보다 입력금액인 " + amount + " 이(가) 작습니다.");
            }

            audience.getBag().minusAmount(fee);
            ticketSeller.getTicketOffice().plusAmount(fee);
            audience.getBag().setTicket(ticket);
    }
}
