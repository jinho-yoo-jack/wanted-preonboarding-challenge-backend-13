package com.wanted.preonboarding.theater.service.handler;

public record TicketSeller(TicketOffice ticketOffice) {

    public Ticket getTicket() {
        return this.ticketOffice().getTicket();
    }

    public void addAmount(Long fee) {
        this.ticketOffice().plusAmount(fee);
    }

    public void removeAmount(Long fee) {
        this.ticketOffice().minusAmount(fee);
    }

    public Long getTicketPrice() {
        return ticketOffice.getTicket().getFee();
    }

    public boolean verifyAudienceGotMoney(Audience audience) {
        return audience.getMoney() > getTicketPrice();
    }
}
