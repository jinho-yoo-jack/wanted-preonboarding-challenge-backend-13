package com.wanted.preonboarding.theater.service.handler;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class TicketTest {

    private final Long expectedFee = 1000L;

    @Test
    @DisplayName("티켓 가격을 얻어온다.")
    void getFee() {
        Ticket target = new Ticket(expectedFee);
        Assertions.assertThat(target.getFee()).isEqualTo(expectedFee);
    }
}