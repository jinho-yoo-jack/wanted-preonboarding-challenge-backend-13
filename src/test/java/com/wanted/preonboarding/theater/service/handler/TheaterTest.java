package com.wanted.preonboarding.theater.service.handler;

import static org.assertj.core.api.Assertions.*;

import java.time.LocalDateTime;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class TheaterTest {

    @Test
    @DisplayName("초대권이 없는 관객은 티켓 구매 후, 극장에 입장한다.")
    void enter_no_invitation() {
        // given
        TicketOffice ticketOffice = new TicketOffice(10000L, new Ticket(100L));
        TicketSeller ticketSeller = new TicketSeller(ticketOffice);

        Audience audience = new Audience(new Bag(1000));
        Theater theater = new Theater();

        // when
        theater.enter(audience, ticketSeller);

        // then
        assertThat(audience.getBag().hasTicket()).isTrue();
        assertThat(audience.getBag().getAmount()).isEqualTo(900);
        assertThat(ticketOffice.getAmount()).isEqualTo(10100L);
    }

    @Test
    @DisplayName("초대권이 있는 관객은 티켓 발급 후, 극장에 입장한다.")
    void enter_invitation() {
        // given
        TicketOffice ticketOffice = new TicketOffice(10000L, new Ticket(100L));
        TicketSeller ticketSeller = new TicketSeller(ticketOffice);

        Invitation invitation = new Invitation(LocalDateTime.of(2023, 8, 28, 15, 12, 11));
        Audience audience = new Audience(new Bag(invitation, 1000));
        Theater theater = new Theater();

        // when
        theater.enter(audience, ticketSeller);

        // then
        assertThat(audience.getBag().hasTicket()).isTrue();
        assertThat(audience.getBag().getAmount()).isEqualTo(1000);
        assertThat(ticketOffice.getAmount()).isEqualTo(10000L);
    }
}