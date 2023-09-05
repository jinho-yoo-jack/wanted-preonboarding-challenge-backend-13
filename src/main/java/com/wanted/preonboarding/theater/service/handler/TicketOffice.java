package com.wanted.preonboarding.theater.service.handler;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;

@Slf4j
public class TicketOffice {
    private long amount;
    private final List<Ticket> tickets;

    public TicketOffice(Long amount, Ticket ... tickets) {
        this.amount = amount;
        this.tickets = Arrays.asList(tickets);
    }

    public Ticket getTicket(){
        return tickets.get(0);
    }

    public void minusAmount(long amount) {
        this.amount -= amount;
    }

    public void sellTicketTo(Audience audience) {
        log.info("Before sell ticket amount: {}", amount);
        plusAmount(audience.buy(getTicket()));
        log.info("Ticket office sell ticket to audience, ticket office amount: {}", amount);
    }

    private void plusAmount(long amount) {
        this.amount += amount;
    }

}
