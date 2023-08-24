package com.wanted.preonboarding.theater.service.handler;

import com.wanted.preonboarding.theater.exception.NoMoneyException;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TheaterImpl implements Theater {

    private final TicketSeller ticketSeller;
    private Ticket ticket;

    public boolean enter(Audience audience) {
        if (!audience.getBag().hasInvitation()) {
            try {
                payMoney(audience);
            } catch (NoMoneyException e) {
                return false;
            }
        }
        audience.getBag().setTicket(ticket);
        return true;
    }

    private void payMoney(Audience audience) {
        Long fee = ticket.getFee();
        audience.getBag().minusAmount(fee);
        ticketSeller.getTicketOffice().plusAmount(fee);
    }

    @PostConstruct
    public void init() {
        ticket = ticketSeller.getTicketOffice().getTicket();
    }

}
