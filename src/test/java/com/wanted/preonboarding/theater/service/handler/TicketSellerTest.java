package com.wanted.preonboarding.theater.service.handler;

import com.wanted.preonboarding.theater.domain.RequestMessage;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TicketSellerTest {

    @Test
    public void 티켓판매(){
        RequestMessage rm = RequestMessage.builder()
                .when(null)
                .amount(50000L)
                .build();
        Audience audience = new Audience(rm);
        TicketSeller ticketSeller = new TicketSeller(10000L, 100L);
        ticketSeller.sellTicket(audience);
        assertThat(audience.getAmount()).isEqualTo(50000L - ticketSeller.getTicketFee());
        assertThat(ticketSeller.getOfficeAmount()).isEqualTo(10000L + ticketSeller.getTicketFee());
    }
}