package com.wanted.preonboarding.theater.service.handler;

import lombok.ToString;
import org.springframework.lang.NonNull;

import java.util.*;

@ToString
public class TicketOffice {

    private Long amount;
    private final List<Ticket> tickets;

    public TicketOffice(@NonNull Long amount, Ticket... tickets) {
        this.amount = amount;
        this.tickets = Arrays.asList(tickets);
    }

    public Ticket getTicket() {
        return this.tickets.get(0);
    }

    public void plusAmount(Long amount) {
        this.amount += amount;
    }

    public void minusAmount(Long amount) {
        this.amount -= amount;
    }
}
