package com.wanted.preonboarding.theater.service.handler;

import com.wanted.preonboarding.cafe.service.handler.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TicketSeller {

    private TicketOffice ticketOffice;

    private Status status;

    public void startWork() {
        this.status = Status.WORKING;
    }

    public void finishWork() {
        this.status = Status.WAITING;
    }

    public void sellTicketTo(Audience audience, Ticket ticket) {
        this.startWork();
        try {
            audience.buyTicket(ticket);
            ticketOffice.plusAmount(ticket.getFee());
            ticketOffice.removedSoldTicket(ticket);
            audience.takeTicket(ticket);
        } finally {
            this.finishWork();
        }
    }

    public void refundTicketTo(Audience audience) {
        this.startWork();
        try {
            Ticket refundTicket = audience.refundTicket();
            Long ticketFee = refundTicket.getFee();
            ticketOffice.setTicket(refundTicket);
            ticketOffice.minusAmount(ticketFee);
            audience.takeRefundMoney(ticketFee);
        } finally {
            this.finishWork();
        }
    }
}
