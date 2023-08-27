package com.wanted.preonboarding.theater.service.handler;

import com.wanted.preonboarding.common.exception.NotEnoughTicketException;
import lombok.Builder;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class TicketOffice {
    private long amount;
    private final List<Ticket> tickets;

    @Builder
    public TicketOffice(Long amount, Ticket ... tickets) {
        this.amount = amount;
        this.tickets = new LinkedList<>(Arrays.asList(tickets));
    }

    public static TicketOffice createTicketOffice(long amount, Ticket ... tickets) {
        return TicketOffice.builder()
                .amount(amount)
                .tickets(tickets)
                .build();
    }

    public Ticket getTicket(){
        Ticket ticket = tickets.get(0);
        if (tickets.size() > 1) {
            tickets.remove(ticket);
        } else {
            throw new NotEnoughTicketException();
        }
        return ticket;
    }

    public void minusAmount(long amount) {
        this.amount -= amount;
    }
    public void plusAmount(long amount) {
        this.amount += amount;
    }


}
