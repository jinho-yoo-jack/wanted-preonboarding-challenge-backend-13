package com.wanted.preonboarding.theater.service.handler;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
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
