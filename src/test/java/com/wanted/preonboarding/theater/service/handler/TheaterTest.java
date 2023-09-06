package com.wanted.preonboarding.theater.service.handler;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TheaterTest {

    Theater theater = new Theater();

    @Test
    @DisplayName("초대장을 보유한 관객에게는 티켓을 무료로 제공한다. ")
    void giveTicket() {
        // given
        Audience audience = new Audience(new Bag(new Invitation(), 10000L));
        TicketSeller ticketSeller = new TicketSeller(new TicketOffice(0L, new Ticket(1000L)));

        // when
        theater.enter(audience, ticketSeller);

        // then
        assertThat(audience.getAmount()).isEqualTo(10000L);
    }

    @Test
    @DisplayName("초대장을 보유하지 않은 관객에게는 티켓을 판매한다. ")
    void sellTicket() {
        // given
        Audience audience = new Audience(new Bag(10000L));
        TicketSeller ticketSeller = new TicketSeller(new TicketOffice(0L, new Ticket(1000L)));

        // when
        theater.enter(audience, ticketSeller);

        // then
        assertThat(audience.getAmount()).isEqualTo(9000L);
    }
}