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

    public TicketOffice(Long amount, List<Ticket> tickets) {
        this.amount = amount;
        this.tickets = tickets;
    }

    public void exchangeInvitation(Audience audience) {
        Ticket ticket = this.issueTicket();
        audience.exchangeInvitation(ticket);
    }

    public void sellTicket(Audience audience){
        Ticket ticket = this.issueTicket();
        try {
            Long fee = audience.buyTicket(ticket);
            this.plusAmount(fee);
        } catch (Exception e) {
            this.addTicket(ticket);
            throw e;
        }
    }

    private Ticket issueTicket() {
        if (this.tickets.size() == 0) {
            throw new IllegalStateException("티켓이 모두 소진되었습니다.");
        }
        return this.tickets.remove(this.tickets.size() - 1);
    }

    private void addTicket(Ticket ticket) {
        this.tickets.add(ticket);
    }

    private void minusAmount(long amount) {
        this.amount -= amount;
    }
    private void plusAmount(long amount) {
        this.amount += amount;
    }

    public Long getAssets() {
        return this.amount;
    }
}
