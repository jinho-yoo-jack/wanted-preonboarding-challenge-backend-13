package com.wanted.preonboarding.theater.service.handler;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class TicketOffice {
    private long amount;
    private List<Ticket> tickets;

    public TicketOffice() {
        this.amount = 20000L;
        this.tickets = Arrays.asList(new Ticket(100L));
    }

    public TicketOffice(long amount, Ticket ticket) {
        this.amount = amount;
        this.tickets = Arrays.asList(ticket);
    }

    public void receiveTicket(Bag bag) {
        Ticket ticket = tickets.get(0);
        bag.setTicket(ticket);
    }

    public void sellTicket(Bag bag) {
        Ticket ticket = tickets.get(0);
        bag.minusAmount(ticket.getFee());
        this.amount += ticket.getFee();
        bag.setTicket(ticket);
    }
}
