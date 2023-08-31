package com.wanted.preonboarding.theater.fixture;

import com.wanted.preonboarding.theater.dto.request.EnterTheaterRequest;
import com.wanted.preonboarding.theater.service.handler.consumer.Invitation;

import java.time.LocalDateTime;

public class EnterTheaterFixture {

    public static final EnterTheaterRequest SUCCESS_ENTER_REQUEST_INVITATION
            = EnterTheaterRequest.builder().invitation(Invitation.builder().when(LocalDateTime.now()).build()).build();

    public static final EnterTheaterRequest SUCCESS_ENTER_REQUEST_BUT_TICKET
            = EnterTheaterRequest.builder().amount(10000L).build();

    public static final EnterTheaterRequest FAIL_ENTER_REQUEST_BUT_TICKET
            = EnterTheaterRequest.builder().amount(1L).build();
}
