package com.wanted.preonboarding.theater.service.handler;

import com.wanted.preonboarding.theater.service.TestTicketPolices;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class TheaterTest {

    @DisplayName("극장 입장")
    @Test
    void enter() {
        // given
        TestTicketPolices testTicketPolices = new TestTicketPolices();
        Theater theater = new Theater(new TicketSeller((new TicketOffice(testTicketPolices))));
        Audience audience = new Audience(new Bag(new Money(1000L)));

        // when
        audience.exchangeTicket(new Ticket(100L));
        String enter = theater.enter(audience);

        // then
        assertThat(audience.hastTicket()).isTrue();
        assertThat(audience.hasInvitation()).isFalse();
        assertThat(enter).isEqualTo("Have a good time.");
    }

    @DisplayName("티켓이 없으면 입장을 못한다.")
    @Test
    void enter_fail_if_audience_have_not_ticket() {
        // given
        TestTicketPolices testTicketPolices = new TestTicketPolices();
        Theater theater = new Theater(new TicketSeller((new TicketOffice(testTicketPolices))));
        Audience audience = new Audience(new Bag(new Money(1000L)));

        // when & then
        assertThatThrownBy(() -> theater.enter(audience))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Fail to buy a ticket.");
    }

    @DisplayName("티켓을 판다")
    @Test
    void sellTickTo() {
        // given
        TestTicketPolices testTicketPolices = new TestTicketPolices();
        Theater theater = new Theater(new TicketSeller((new TicketOffice(testTicketPolices))));
        Audience audience = new Audience(new Bag(new Money(1000L)));

        // when
        theater.sellTicketTo(audience);

        // then
        assertThat(audience.hastTicket()).isTrue();
        assertThat(audience.hasInvitation()).isFalse();
        assertThat(audience.getAmount()).isEqualTo(new Money(900L));
    }
}