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
            list.add(new TicketSeller(Status.WAITING));
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

    public void removedSoldTicket(Ticket ticket) {
        this.tickets.remove(ticket);
    }

    public long getTicketPrice() {
        return tickets.stream()
                .findFirst()
                .orElseThrow(() -> new TheaterException(TheaterErrorCode.NOT_FOUND_TICKET))
                .getFee();
    }

    public TicketSeller findAvailableTicketSeller() {
        return this.ticketSellers.stream()
                .filter(ticketSeller -> ticketSeller.getStatus() == Status.WAITING)
                .findAny()
                .orElseThrow(() -> new TheaterException(TheaterErrorCode.ALL_TICKET_SELLER_IN_WORK));
    }

    public void sellTicketTo(Audience audience) {
        TicketSeller ticketSeller = findAvailableTicketSeller();
        Ticket ticket = getAvailableTicket();
        try {
            ticketSeller.startWork();
            audience.buyTicket(ticket);
            this.plusAmount(ticket.getFee());
            this.removedSoldTicket(ticket);
            audience.takeTicket(ticket);
        } finally {
            ticketSeller.finishWork();
        }
    }

    public void refundTicketTo(Audience audience) {
        TicketSeller ticketSeller = findAvailableTicketSeller();
        try {
            ticketSeller.startWork();
            Ticket refundTicket = audience.refundTicket();
            Long ticketFee = refundTicket.getFee();
            this.setTicket(refundTicket);
            this.minusAmount(ticketFee);
            audience.takeRefundMoney(ticketFee);
        } finally {
            ticketSeller.finishWork();
        }
    }

    public List<TicketSeller> getTicketSellers() {
        return this.ticketSellers;
    }

    public List<Ticket> getTicketList() {
        return this.tickets;
    }

    public void setTicket(Ticket ticket) {
        this.tickets.add(ticket);
    }

    public long getAmount() {
        return this.amount;
    }

    public void minusAmount(long amount) {
        this.amount -= amount;
    }

    public void plusAmount(long amount) {
        this.amount += amount;
    }
}
