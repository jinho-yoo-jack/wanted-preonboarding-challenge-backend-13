package com.wanted.preonboarding.theater.service.handler;

import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class TicketOffice {
    private Money amount;
    private final List<Ticket> tickets;

    public TicketOffice(TicketPolicies ticketPolicies) {
        this.amount = new Money(ticketPolicies.ticketOfficeAmount());
        this.tickets = ticketPolicies.ticketAmount();
    }

    public Ticket changeInvitiactionByTicket(Audience audience) {
        return audience.exchangeTicket(getTicket());
    }

    public boolean sellTicketTo(Audience audience) {
        Money beforeSell = amount;
        Money afterSell = plusAmount(audience.buy(getTicket()));

        return beforeSell != afterSell;
    }

    private void minusAmount(Money amount) {
        this.amount = this.amount.minus(amount);
    }

    private Money plusAmount(Money amount) {
        return this.amount = this.amount.plus(amount);
    }

    private Ticket getTicket() {
        return tickets.remove(0);
    }
}
