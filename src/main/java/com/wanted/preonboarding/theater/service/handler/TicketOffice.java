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

    public Ticket getTicket(){
        return tickets.get(0);
    }

    public void minusAmount(long amount) {
        this.amount -= amount;
    }
    public void plusAmount(long amount) {
        this.amount += amount;
    }

    public Ticket exchangeInvitationWithTicket(Ticket ticket) {
        // TODO: 티켓-초대권 교환 로직 추가
        return ticket;
    }

    public Ticket sellTicket(Ticket ticket) {
        plusAmount(ticket.getFee());
        // TODO : 티켓 판매 로직 추가
        return ticket;
    }
}
