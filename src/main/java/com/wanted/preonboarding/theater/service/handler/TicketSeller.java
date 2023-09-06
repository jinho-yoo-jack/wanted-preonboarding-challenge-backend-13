package com.wanted.preonboarding.theater.service.handler;

/**
 * 리펙토링한 부분:
 *                  -  getTicketOffice()로 ticketOffice를 외부로 노출시키기 보다
 *                     sellTo(), receiveFee()을 통해 내부 구현을 은닉화 함.
 */
public class TicketSeller {

    private final TicketOffice ticketOffice;

    public TicketSeller(TicketOffice ticketOffice) {
        this.ticketOffice = ticketOffice;
    }

    public long sellTo(Audience audience) throws Exception {
        Ticket ticket = ticketOffice.getTicket();
        return audience.buy(ticket);
    }

    public void receiveFee(long fee) {
        ticketOffice.increaseAmountWithFee(fee);
    }
}
