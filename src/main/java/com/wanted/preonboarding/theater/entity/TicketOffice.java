package com.wanted.preonboarding.theater.entity;

import lombok.Builder;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class TicketOffice {
    private long amount;
    private final Deque<Ticket> tickets;

    @Builder
    public TicketOffice(Long amount, List<Ticket> tickets) {
        this.amount = amount;
        this.tickets = new ArrayDeque<>(tickets);
    }

    public Ticket getTicket(){
        return (!tickets.isEmpty()) ? tickets.pop() : null;
    }

    public void minusAmount(long amount) {
        this.amount -= amount;
    }
    public void plusAmount(long amount) {
        this.amount += amount;
    }
}
