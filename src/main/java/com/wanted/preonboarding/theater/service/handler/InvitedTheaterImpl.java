package com.wanted.preonboarding.theater.service.handler;

import com.wanted.preonboarding.theater.entity.Audience;
import com.wanted.preonboarding.theater.entity.Ticket;
import com.wanted.preonboarding.theater.entity.TicketSeller;
import org.springframework.stereotype.Component;

@Component
public class InvitedTheaterImpl implements Theater {
    public void enter(Audience audience, TicketSeller ticketSeller){

        // 소지권이 있다면 티켓 확인
        Ticket ticket = ticketSeller.getTicketOffice().getTicket();
        audience.getBag().setTicket(ticket);
    }
}
