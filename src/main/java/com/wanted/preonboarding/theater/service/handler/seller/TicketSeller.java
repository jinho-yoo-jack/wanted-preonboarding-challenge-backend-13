package com.wanted.preonboarding.theater.service.handler.seller;

import com.wanted.preonboarding.theater.service.handler.consumer.Consumer;
import lombok.Builder;


@Builder
public class TicketSeller implements Seller {
    private final TicketOffice ticketOffice;

    public TicketSeller(TicketOffice ticketOffice){
        this.ticketOffice = ticketOffice;
    }

    @Override
    public void receiveFee() {
        ticketOffice.plusAmount(ticketOffice.getTicket().getFee());
    }

    @Override
    public void giveTicket(Consumer consumer) {
        consumer.receiveTicket(ticketOffice.getTicket());
    }

    @Override
    public Long getTicketFee() {
        return ticketOffice.getTicket().getFee();
    }
}
