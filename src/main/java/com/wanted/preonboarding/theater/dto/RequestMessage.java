package com.wanted.preonboarding.theater.dto;

import com.wanted.preonboarding.theater.service.handler.Invitation;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RequestMessage {

    private final Long amount;
    private final Invitation invitation;
    private final Long ticketFee;
}
