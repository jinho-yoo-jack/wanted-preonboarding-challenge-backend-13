package com.wanted.preonboarding.theater.service.handler;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class TheaterTest {

    Theater theater = new Theater();

    @Test
    @DisplayName("초대장이 있는 관객은 돈을 내지 않고 입장")
    void enterInvited() throws Exception {
        // given
        Audience audience = new Audience(new Bag(new Invitation(),10000));
        TicketSeller ticketSeller = new TicketSeller(new TicketOffice(10000L, new Ticket(5000L)));
        // when
        theater.enter(audience,ticketSeller);

        // then
        Bag bag = (Bag) ReflectionTestUtils.getField(audience, "bag");
        Long amount = (Long) ReflectionTestUtils.getField(bag, "amount");

        assertThat(amount).isEqualTo(10000);
    }

    @Test
    @DisplayName("초대장이 없는 관객은 돈을 내고 입장")
    void enterBuyTicket() throws Exception {
        // given
        Audience audience = new Audience(new Bag(null,10000));
        TicketSeller ticketSeller = new TicketSeller(new TicketOffice(10000L, new Ticket(5000L)));
        // when
        theater.enter(audience,ticketSeller);

        // then
        Bag bag = (Bag) ReflectionTestUtils.getField(audience, "bag");
        Long amount = (Long) ReflectionTestUtils.getField(bag, "amount");

        assertThat(amount).isEqualTo(5000);
    }
}