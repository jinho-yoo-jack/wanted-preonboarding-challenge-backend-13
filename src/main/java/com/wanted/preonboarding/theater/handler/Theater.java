package com.wanted.preonboarding.theater.handler;

import com.wanted.preonboarding.theater.entity.Audience;
import com.wanted.preonboarding.theater.entity.Ticket;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
@RequiredArgsConstructor
public class Theater {
    private final TicketSeller ticketSeller;

    public void enter(Audience audience) {
        if (audience.getBag().hasInvitation()) {
            Ticket ticket = ticketSeller.getTicketOffice().getTicket();
            Assert.notNull(ticket, "티켓이 모두 소진되었습니다.");
            audience.getBag().setTicket(ticket);
        } else if (!audience.getBag().hasTicket()) {
            Ticket ticket = ticketSeller.getTicketOffice().getTicket();
            Assert.notNull(ticket, "티켓이 모두 소진되었습니다.");
            audience.getBag().minusAmount(ticket.getFee());
            ticketSeller.getTicketOffice().plusAmount(ticket.getFee());
            audience.getBag().setTicket(ticket);
        } else if (audience.getBag().hasTicket()) {
            //관객이 이미 티켓을 갖고 있는 경우
        }

    }
}
