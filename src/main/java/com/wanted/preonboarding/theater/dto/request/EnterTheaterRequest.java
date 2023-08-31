package com.wanted.preonboarding.theater.dto.request;

import com.wanted.preonboarding.theater.service.handler.consumer.Invitation;
import lombok.Builder;
import lombok.Getter;

@Getter
public class EnterTheaterRequest {

    private final Long amount;

    private final Invitation invitation;

    @Builder
    public EnterTheaterRequest(Long amount, Invitation invitation) {
        this.amount = amount;
        this.invitation = invitation;
    }
}
