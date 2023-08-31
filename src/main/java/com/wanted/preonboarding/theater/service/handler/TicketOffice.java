package com.wanted.preonboarding.theater.service.handler;

import java.util.Arrays;
import java.util.List;

public class TicketOffice {
    private long money;
    private final List<Ticket> tickets;

    public TicketOffice(Long money, Ticket ... tickets) {
        this.money = money;
        this.tickets = Arrays.asList(tickets);
    }

    public Ticket getTicket(){
        return tickets.get(0);
    }

    public void minusMoney(long amount) {
        this.money -= amount;
    }
    public void plusMoney(long amount) {
        this.money += amount;
    }
}
