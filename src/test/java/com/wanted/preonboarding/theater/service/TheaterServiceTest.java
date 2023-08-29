package com.wanted.preonboarding.theater.service;

import static org.assertj.core.api.Assertions.*;

import com.wanted.preonboarding.theater.service.handler.Audience;
import com.wanted.preonboarding.theater.service.handler.Bag;
import com.wanted.preonboarding.theater.service.handler.Invitation;
import com.wanted.preonboarding.theater.service.handler.Ticket;
import com.wanted.preonboarding.theater.service.handler.TicketOffice;
import com.wanted.preonboarding.theater.service.handler.TicketSeller;
import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
class TheaterServiceTest {

    @Autowired
    TheaterService theaterService;

    @Test
    @DisplayName("소극장에 입장하는 관객의 티켓을 확인하고, 만약 티켓이 없다면 구매 후, 입장을 시키고 티켓이 있다면 티켓 확인 후, 입장 시킨다.")
    void example() {
        // given

        // when

        // then
    }

    @Test
    @DisplayName("관객이 티켓을 가지고 있으면, 극장에 입장시킨다.")
    void enter() {
        // given
        Audience audience = new Audience(new Bag(new Invitation(), 1000));
        TicketSeller ticketSeller = new TicketSeller(new TicketOffice(20000L, new Ticket(100L)));

        // when
        String enterMessage = theaterService.enter();

        // then
        assertThat(enterMessage).isEqualTo("Have a good time.");
    }
}