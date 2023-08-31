package com.wanted.preonboarding.theater.service.handler;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class TicketOffice {
    private long amount;
    private final List<Ticket> tickets;

    public void changeTicket(Audience audience) {
        Ticket ticket = getTicket();
        audience.getBag().setTicket(ticket);
    }

    public void sellTicket(Audience audience) {
        Ticket ticket = getTicket();
        Long fee = ticket.getFee();
        audience.getBag().minusAmount(fee);
        plusAmount(fee);
        audience.getBag().setTicket(ticket);
    }

    public Ticket getTicket() {
        return tickets.get(0);
    }

    public void plusAmount(long amount) {
        this.amount += amount;
    }
}
