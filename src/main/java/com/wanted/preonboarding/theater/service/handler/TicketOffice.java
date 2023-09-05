package com.wanted.preonboarding.theater.service.handler;

import com.wanted.preonboarding.theater.exception.TheaterErrorCode;
import com.wanted.preonboarding.theater.exception.TheaterException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class TicketOffice {
    private long amount;
    private final List<Ticket> tickets = new ArrayList<>();

    public TicketOffice(Long amount, @Autowired List<Ticket> tickets) {
        this.amount = amount;
        this.tickets.addAll(tickets);
    }

    public Ticket getTicket() {
        if (tickets.size() > 0) {
            return tickets.remove(0);
        }
        throw new TheaterException(TheaterErrorCode.TICKET_SOLD_OUT);
    }

    public void setTicket(Ticket ticket) {
        this.tickets.add(ticket);
    }

    public void minusAmount(long amount) {
        this.amount -= amount;
    }

    public void plusAmount(long amount) {
        this.amount += amount;
    }
}
