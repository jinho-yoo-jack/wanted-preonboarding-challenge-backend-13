package com.wanted.preonboarding.theater.service.handler;

import com.wanted.preonboarding.cafe.service.handler.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TicketSeller {

    private Status status;

    public void sellTicketTo(Audience audience, Ticket ticket) {
        startWork();
        audience.buyTicket(ticket);
        finishWork();
    }

    public void refundTicketTo(TicketOffice ticketOffice, Ticket ticket) {
        startWork();
        ticketOffice.setTicket(ticket);
        ticketOffice.minusAmount(ticket.getFee());
        finishWork();
    }

    private void startWork() {
        this.status = Status.WORKING;
    }

    private void finishWork() {
        this.status = Status.WAITING;
    }
}
