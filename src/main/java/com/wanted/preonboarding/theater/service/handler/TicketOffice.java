package com.wanted.preonboarding.theater.service.handler;

import java.util.Arrays;
import java.util.List;

public class TicketOffice {
    private long amount;
    private final List<Ticket> tickets;

    public TicketOffice(Long amount, Ticket ... tickets) {
        this.amount = amount;
        this.tickets = Arrays.asList(tickets);
    }

    public Ticket publishTicket(){
        return getTicket();
    }

    public void increaseSalesAmount(long amount){
        plusAmount(amount);
    }

    public Ticket getTicket(){
        return tickets.get(0);
    }

    public void minusAmount(long amount) {
        this.amount -= amount;
    }
    private void plusAmount(long amount) {
        this.amount += amount;
    }

    public Long getAmount(){
        return amount;
    }
}
