package com.wanted.preonboarding.theater.service.handler;

import com.wanted.preonboarding.theater.dto.TheaterResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Theater {

    public TheaterResponse.Enter enter(Audience audience, TicketSeller ticketSeller){
        Bag audienceBag = audience.getBag(); // 고객의 가방
        TicketOffice ticketOffice = ticketSeller.getTicketOffice(); // 티켓 관리 사무소

        return receiveTicket(audienceBag, ticketOffice);
    }

    private TheaterResponse.Enter receiveTicket(Bag audienceBag, TicketOffice ticketOffice) {
        boolean hasInvitation = audienceBag.hasInvitation(); // 극장 초대 여부
        Ticket ticket = ticketOffice.getTicket(); // 티켓

        if(hasInvitation) {
            audienceBag.receiveTicket(ticket);
            return TheaterResponse.Enter.isTicketBought(false);
        }else {
            Long fee = ticket.getFee(); // 티캣의 가격

            audienceBag.buyTicket(fee);
            ticketOffice.sellTicket(fee);
            audienceBag.receiveTicket(ticket);
            return TheaterResponse.Enter.isTicketBought(true);
        }
    }
}
