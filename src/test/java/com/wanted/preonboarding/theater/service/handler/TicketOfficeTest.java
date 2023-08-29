package com.wanted.preonboarding.theater.service.handler;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TicketOfficeTest {

    @Test
    @DisplayName("예매권을 보유한 관람객에게 티켓을 발급한다.")
    void give_ticket() {
        // given
        TicketOffice ticketOffice = new TicketOffice(
                10000L, new Ticket(1000L)
        );

        // when
        Ticket ticket = ticketOffice.giveTicket();

        // then
        assertThat(ticket).isNotNull();
        assertThat(ticketOffice.getAmount()).isEqualTo(10000L);
    }

    @Test
    @DisplayName("예매권을 보유하지 않은 관람객에게는 티켓값을 받고 티켓을 발급해준다.")
    void sell_ticket() {
        // given
        TicketOffice ticketOffice = new TicketOffice(
                10000L, new Ticket(1000L)
        );

        // when
        Ticket ticket = ticketOffice.sellTicket();

        // then
        assertThat(ticket).isNotNull();
        assertThat(ticketOffice.getAmount()).isEqualTo(11000L);
    }
}