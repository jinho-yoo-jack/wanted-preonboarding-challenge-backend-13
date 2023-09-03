package com.wanted.preonboarding.theater.service.handler;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@AllArgsConstructor
@RequiredArgsConstructor
public class TicketOffice {
    private long amount;
    private final List<Ticket> tickets;

    public TicketOffice(long amount, Ticket ticket) {
        this.amount = amount;
        this.tickets = Arrays.asList(ticket);
    }

    public Ticket getTicket(){
        return tickets.get(0);
    }

    public void minusAmount(long amount) {
        this.amount -= amount;
    }
    public void plusAmount(long amount) {
        this.amount += amount;
    }
}
