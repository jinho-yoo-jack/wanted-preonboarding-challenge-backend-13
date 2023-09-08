package com.wanted.preonboarding.theater.service.handler;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

class BagTest {

    @Test
    @DisplayName("가방에 돈이 티켓값보다 많이 들어있으면 구매에 성공한다.")
    void givenAmountInBagWhenCallGetAmountThenReturnExpectedAmount() {
        Bag target = new Bag(null, 1000L);
        Long expectedAmount = 1000L;
        assertThat(target.getAmount()).isEqualTo(expectedAmount);
    }

    @Test
    @DisplayName("관람객이 초대권을 꺼내면 가방에 든 초대권을 반환한다.")
    void givenInvitationInBagWhenCallGetInvitationThenReturnExpectedInvitation() {
        LocalDateTime expectedWhen = LocalDateTime.now();
        boolean expectedIsUsed = false;
        Invitation expectedInvitation = new Invitation(expectedWhen, expectedIsUsed);
        Bag target = new Bag(expectedInvitation, 1000L);
        assertThat(target.getInvitation()).isEqualTo(expectedInvitation);
    }

    @Test
    @DisplayName("관람객이 티켓을 꺼내면 가방에 든 티켓을 반환한다.")
    void givenTicketInBagWhenCallGetTicketThenReturnExpectedTicket() {
        Ticket expectedTicket = new Ticket(1000L);
        Bag target = new Bag();
        target.takeTicket(expectedTicket);
        assertThat(target.getTicket()).isEqualTo(expectedTicket);
    }

    @Test
    @DisplayName("관람객이 티켓을 가방에 넣으면 티켓이 가방에 들어간다.")
    void givenNoTicketInBagWhenCallSetTicketThenSetTicketInBag() {
        Ticket expectedTicket = new Ticket(1000L);
        Bag target = new Bag();
        target.takeTicket(expectedTicket);
        assertThat(target.getTicket()).isEqualTo(expectedTicket);
    }
}