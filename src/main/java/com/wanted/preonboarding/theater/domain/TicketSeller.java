package com.wanted.preonboarding.theater.domain;

public class TicketSeller {
    private final TicketOffice ticketOffice;

    public TicketSeller(TicketOffice ticketOffice){
        this.ticketOffice = ticketOffice;
    }

    public Ticket getTicket() {
        return ticketOffice.getTicket();
    }

    public Ticket getTicket(Audience audience) {
        // 여기서 고객에 따른 금액 변동 조건 넣을 수 있음
        return new Ticket(200L);
    }

    public void sellTicket(Ticket sellingTicket) {
        ticketOffice.plusAmount(sellingTicket.getFee());
    }
}
