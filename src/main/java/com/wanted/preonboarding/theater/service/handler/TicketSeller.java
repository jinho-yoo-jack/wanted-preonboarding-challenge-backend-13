package com.wanted.preonboarding.theater.service.handler;

public class TicketSeller {
    private final TicketOffice ticketOffice;

    public TicketSeller(TicketOffice ticketOffice){
        this.ticketOffice = ticketOffice;
    }

    public void checkTicket(Audience audience) {
        if (audience.hasInvitation()) {
            ticketOffice.exchangeInvitation(audience);
        }
        if (!audience.hasInvitation()) {
            ticketOffice.sellTicket(audience);
        }
    }

    public Long getAssets() {
        return ticketOffice.getAssets();
    }
}
