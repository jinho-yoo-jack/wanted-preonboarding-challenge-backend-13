package com.wanted.preonboarding.theater.service.model;

import lombok.Getter;

public class RequestMessage {
    @Getter
    private long money;

    @Getter
    private Boolean hasInvitation;

    @Getter
    private Long fee;
}
