package com.wanted.preonboarding.theater.service.handler;

import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.List;

// 티켓 상점 클래스
@RequiredArgsConstructor
public class TicketOffice {
    private long amount;
    private final List<Ticket> tickets;

    public TicketOffice(Long amount, Ticket ... tickets) {
        this.amount = amount;
        this.tickets = Arrays.asList(tickets);
    }

    public Ticket getTicket(){
        if(!tickets.isEmpty()){
            return tickets.get(0);
        }
        return null;
    }

    public void minusAmount(long amount) {
        this.amount -= amount;
    }
    public void plusAmount(long amount) {
        this.amount += amount;
    }
}
