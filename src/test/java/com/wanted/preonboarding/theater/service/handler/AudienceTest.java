package com.wanted.preonboarding.theater.service.handler;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class AudienceTest {

    @DisplayName("고객은 초대장이 없으면 티켓을 구매해야한다")
    @Test
    public void buyTicketWithoutInvitation() {
        // given
        Ticket ticket = new Ticket(100L);
        Audience audience = new Audience(new Bag(1000L));

        // when
        audience.buy(ticket);

        // then
        assertThat(audience.getBag().hasTicket()).isEqualTo(true);
        assertThat(audience.getBag().getAmount()).isEqualTo(900L);
    }

    @DisplayName("고객이 초대장을 가지고 있으면 티켓으로 교환할 수 있다.")
    @Test
    public void buyTicketWithInvitation() {
        // given
        Ticket ticket = new Ticket(100L);
        Audience audience = new Audience(new Bag(new Invitation(), 1000L));

        // when
        audience.buy(ticket);

        // then
        assertThat(audience.getBag().hasTicket()).isEqualTo(true);
        assertThat(audience.getBag().getAmount()).isEqualTo(1000L);
    }

}