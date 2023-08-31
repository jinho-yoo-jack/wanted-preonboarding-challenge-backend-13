package com.wanted.preonboarding.theater.service.handler;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;


public class TicketSellerTest {

    @Test
    public void 관객이_초대권을_갖고_있으면_티켓값을_받지_않는다() {
        // given
        TicketSeller ticketSeller = new TicketSeller(new TicketOffice());
        Audience audience = new Audience(Bag.of(10000L, LocalDateTime.of(2023, 12, 31, 0, 0, 0)));

        // when
        ticketSeller.sell(audience);

        // then
        Assertions.assertThat(10000L).isEqualTo(ticketSeller.getTicketOffice().getAmount());
    }

    @Test
    public void 관객이_초대권을_갖고_있지_않으면_티켓값을_받는다() {
        // given
        TicketSeller ticketSeller = new TicketSeller(new TicketOffice());
        Audience audience = new Audience(Bag.of(10000L, null));

        // when
        ticketSeller.sell(audience);

        // then
        Assertions.assertThat(10100L).isEqualTo(ticketSeller.getTicketOffice().getAmount());

    }

}