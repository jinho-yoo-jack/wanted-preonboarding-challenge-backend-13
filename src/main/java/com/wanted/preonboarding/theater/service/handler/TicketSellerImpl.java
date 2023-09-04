package com.wanted.preonboarding.theater.service.handler;

public class TicketSellerImpl implements TicketSeller{

    private final TicketOffice ticketOffice;

    public TicketSellerImpl(TicketOffice ticketOffice) {
        this.ticketOffice = ticketOffice;
    }

    @Override
    public TicketOffice getTicketOffice() {
        return this.ticketOffice;
    }
}
