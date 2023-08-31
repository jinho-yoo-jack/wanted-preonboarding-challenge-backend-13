package com.wanted.preonboarding.theater.service;

import com.wanted.preonboarding.theater.dto.request.EnterTheaterRequest;
import com.wanted.preonboarding.theater.fixture.EnterTheaterFixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TheaterServiceTest {

    @Autowired
    private TheaterService theaterService;

    @Test
    @DisplayName("입장 성공 - 입장권 있을 때")
    void successEnterTheaterWhenConsumerHasInvitation() {

        // given
        EnterTheaterRequest successEnterRequest = EnterTheaterFixture.SUCCESS_ENTER_REQUEST_INVITATION;

        // when
        String resultMessage = theaterService.enter(successEnterRequest);

        // then

        assertEquals("Have a good time.", resultMessage);
    }

    @Test
    @DisplayName("입장 성공 - 입장권 없을 때 티켓 구매")
    void successEnterTheaterWhenBuyTicket() {

        // given
        EnterTheaterRequest successEnterRequest = EnterTheaterFixture.SUCCESS_ENTER_REQUEST_BUT_TICKET;

        // when
        String resultMessage = theaterService.enter(successEnterRequest);

        // then
        assertEquals("Have a good time.", resultMessage);
    }

    @Test
    @DisplayName("입장 실패 - 입장권 없을 때 티켓 구매할 amount 부족")
    void failEnterTheaterWhenNotEnoughAmount() {

        // given
        EnterTheaterRequest successEnterRequest = EnterTheaterFixture.FAIL_ENTER_REQUEST_BUT_TICKET;

        // when
        String resultMessage = theaterService.enter(successEnterRequest);

        // then
        assertEquals("not enough amount to buy ticket.", resultMessage);
    }

}