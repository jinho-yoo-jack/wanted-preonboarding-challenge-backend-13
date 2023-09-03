package com.wanted.preonboarding.theater.domain;

import java.util.Arrays;
import java.util.List;

public class TicketOffice {
    private long amount;
    private final List<Ticket> tickets;

    public TicketOffice(Long amount, Ticket... tickets) {
        this.amount = amount;
        this.tickets = Arrays.asList(tickets);
    }

    private Ticket getTicket() {
        if (tickets.get(0) == null) {
            throw new IllegalStateException("티켓이 없습니다.");
        }
        return tickets.get(0);
    }

    public Ticket changeTicket() {
        return tickets.remove(0);
    }

    public Ticket sellTicket(Long money) {
        Ticket ticket = getTicket();
        if (ticket.getFee() > money) {
            throw new IllegalStateException("돈이 부족합니다.");
        }
        plusAmount(money);
        return tickets.remove(0);
    }

    public void minusAmount(long amount) {
        this.amount -= amount;
    }

    private void plusAmount(long amount) {
        this.amount += amount;
    }
}
