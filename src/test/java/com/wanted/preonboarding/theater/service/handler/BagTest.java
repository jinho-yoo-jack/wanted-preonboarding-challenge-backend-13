package com.wanted.preonboarding.theater.service.handler;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

public class BagTest {

    @Test
    public void 초대권이_있으면_티켓값이_공짜다() {
        // given
        Bag bag = Bag.of(10000L, LocalDateTime.of(2023, 12, 31, 0, 0, 0));

        // when
        long fee = bag.buy(new Ticket(100L));

        // then
        assertThat(fee).isEqualTo(0L);
        assertThat(bag.getAmount()).isEqualTo(10000L);
    }

    @Test
    public void 초대권이_없으면_티켓값을_지불해야_한다() {
        // given
        Bag bag = Bag.of(10000L, null);

        // when
        long fee = bag.buy(new Ticket(100L));

        // then
        assertThat(fee).isEqualTo(100L);
        assertThat(bag.getAmount()).isEqualTo(9900L);
    }
}