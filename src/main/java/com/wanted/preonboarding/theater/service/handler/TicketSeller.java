package com.wanted.preonboarding.theater.service.handler;

import lombok.Builder;
import lombok.Getter;

@Getter
public class TicketSeller {
    
    private final TicketOffice ticketOffice;
    
    @Builder
    public TicketSeller(TicketOffice ticketOffice) {
        this.ticketOffice = ticketOffice;
    }
    
    /**
     * 관객에게 티캣 판매
     *
     * @param audience 티켓을 구매할 관객
     * @return 구매한 티켓의 가격
     */
    public long sellTo(Audience audience) {
        return audience.buy(ticketOffice.publishTicket());
    }
    
    /**
     * 티켓 구입 비용을 받음
     *
     * @param ticketFee 티켓 가격
     */
    public void receivePay(long ticketFee) {
        ticketOffice.increaseSalesAmount(ticketFee);
    }
}
