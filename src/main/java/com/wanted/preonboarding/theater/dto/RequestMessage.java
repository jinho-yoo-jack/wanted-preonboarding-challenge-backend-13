package com.wanted.preonboarding.theater.dto;

import lombok.Getter;

public class RequestMessage {

    @Getter
    private long amount;
    private boolean hasInvitation;

    public boolean hasInvitation() {
        return hasInvitation;
    }
}
