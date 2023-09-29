package com.wanted.preonboarding.theater.service.handler;

import com.wanted.preonboarding.cafe.service.handler.Status;
import com.wanted.preonboarding.theater.exception.TheaterErrorCode;
import com.wanted.preonboarding.theater.exception.TheaterException;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class TicketOffice {

    private final List<TicketSeller> ticketSellers;
    private final List<Ticket> tickets;
    private long amount;

    public TicketOffice(List<TicketSeller> ticketSellers, List<Ticket> tickets, long amount) {
        this.ticketSellers = ticketSellers;
        this.tickets = tickets;
        this.amount = amount;
    }

    public List<TicketSeller> createTicketSeller(int count) {
        List<TicketSeller> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            list.add(new TicketSeller(this, Status.WAITING));
        }
        return list;
    }

    public void setTicketSeller(TicketSeller ticketSeller) {
        this.ticketSellers.add(ticketSeller);
    }

    public List<Ticket> createTicket(int count) {
        List<Ticket> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            list.add(new Ticket(1000L));
        }
        return list;
    }

    public Ticket getAvailableTicket() {
        if (tickets.size() > 0) {
            return tickets.get(0);
        }
        throw new TheaterException(TheaterErrorCode.TICKET_SOLD_OUT);
    }

    protected void removedSoldTicket(Ticket ticket) {
        this.tickets.remove(ticket);
    }

    protected long getTicketPrice() {
        return tickets.stream()
                .findFirst()
                .orElseThrow(() -> new TheaterException(TheaterErrorCode.NOT_FOUND_TICKET))
                .getFee();
    }

    protected TicketSeller findAvailableTicketSeller() {
        return this.ticketSellers.stream()
                .filter(ticketSeller -> ticketSeller.getStatus() == Status.WAITING)
                .findAny()
                .orElseThrow(() -> new TheaterException(TheaterErrorCode.ALL_TICKET_SELLER_IN_WORK));
    }

    public void sellTicketTo(Audience audience) {
        TicketSeller ticketSeller = findAvailableTicketSeller();
        Ticket ticket = getAvailableTicket();
        ticketSeller.sellTicketTo(audience, ticket);
    }

    public void refundTicketTo(Audience audience) {
        TicketSeller ticketSeller = findAvailableTicketSeller();
        ticketSeller.refundTicketTo(audience);
    }

    protected List<TicketSeller> getTicketSellers() {
        return this.ticketSellers;
    }

    protected List<Ticket> getTicketList() {
        return this.tickets;
    }

    public void setTicket(Ticket ticket) {
        this.tickets.add(ticket);
    }

    protected long getAmount() {
        return this.amount;
    }

    protected void minusAmount(long amount) {
        this.amount -= amount;
    }

    protected void plusAmount(long amount) {
        this.amount += amount;
    }
}
