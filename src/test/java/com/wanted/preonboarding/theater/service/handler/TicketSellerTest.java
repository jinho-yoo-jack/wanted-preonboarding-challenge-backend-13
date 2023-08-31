package com.wanted.preonboarding.theater.service.handler;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
class TicketSellerTest {
    @Test
    @DisplayName("예매권이 없는 관객에게 티켓을 판매한다.")
    void sell_ticket_by_none_invitation() {
        // given
        TicketOffice ticketOffice = new TicketOffice(10000L, new Ticket(100L));
        TicketSeller ticketSeller = new TicketSeller(ticketOffice);

        Audience audience = new Audience(new Bag(1000));

        // when
        ticketSeller.sellTicketTo(audience);

        // then
        assertThat(audience.getBag().hasTicket()).isTrue();
        assertThat(ticketOffice.getAmount()).isEqualTo(10100L);
        assertThat(audience.getBag().getAmount()).isEqualTo(900);
    }

    @Test
    @DisplayName("예매권을 소유한 관객에게 티켓을 지급한다.")
    void give_ticket_by_invitation() {
        // given
        TicketOffice ticketOffice = new TicketOffice(10000L, new Ticket(100L));
        TicketSeller ticketSeller = new TicketSeller(ticketOffice);

        Audience audience = new Audience(new Bag(1000));

        // when
        ticketSeller.giveTicketTo(audience);

        // then
        assertThat(audience.getBag().hasTicket()).isTrue();
        assertThat(audience.getBag().getAmount()).isEqualTo(1000);
        assertThat(ticketOffice.getAmount()).isEqualTo(10000L);
    }
}