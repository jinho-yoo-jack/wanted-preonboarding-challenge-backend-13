package com.wanted.preonboarding.theater.service.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class TicketOffice {
    private long amount;
    private final List<Ticket> tickets;

    @Autowired
    public TicketOffice(List<Ticket> tickets) {
        this.amount = 2000000000;
        Ticket ticket = new Ticket(20000L);
        this.tickets = Collections.nCopies(1000000, ticket);
    }

    public void changeTicket(Audience audience) {
        Ticket ticket = getTicket();
        audience.getBag().setTicket(ticket);
    }

    public boolean sellTicket(Audience audience) {
        Ticket ticket = getTicket();
        Long fee = ticket.getFee();
        if (audience.getBag().getAmount() < fee) {
            return false;
        } else {
            audience.getBag().minusAmount(fee);
            plusAmount(fee);
            audience.getBag().setTicket(ticket);
            return true;
        }
    }

    public Ticket getTicket() {
        return tickets.get(0);
    }

    public void plusAmount(long amount) {
        this.amount += amount;
    }
}
