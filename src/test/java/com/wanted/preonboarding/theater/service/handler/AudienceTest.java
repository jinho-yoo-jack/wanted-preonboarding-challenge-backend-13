package com.wanted.preonboarding.theater.service.handler;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;

class AudienceTest {

    @DisplayName("초대 티켓을 가지고 있는지 확인")
    @Test
    void hasInvitation() {
        Audience audience = new Audience(new Bag(new Money(100L)));

        assertFalse(audience.hasInvitation());
    }

    @DisplayName("티켓 사기")
    @Test
    void buy() {
        Audience audience = new Audience(new Bag(new Money(100L)));
        Ticket ticket = new Ticket(100L);

        audience.buy(ticket);

        assertThat(audience.hastTicket()).isTrue();
    }

    @DisplayName("티켓을 가지고 있는지 확인")
    @Test
    void hasTicket() {
        // given
        Audience audience = new Audience(new Bag(new Money(100L)));
        Ticket ticket = new Ticket(100L);
        audience.buy(ticket);

        // when & then
        assertThat(audience.hastTicket()).isTrue();
    }

    @DisplayName("티켓 교환")
    @Test
    void exchangeTicket() {
        Audience audience = new Audience(new Bag(new Money(100L)));
        Ticket ticket = new Ticket(100L);

        Ticket exchangeTicket = audience.exchangeTicket(ticket);

        assertThat(audience.hastTicket()).isTrue();
        assertThat(audience.hasInvitation()).isFalse();
    }
}