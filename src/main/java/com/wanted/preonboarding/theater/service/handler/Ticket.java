package com.wanted.preonboarding.theater.service.handler;

import lombok.AllArgsConstructor;
import lombok.Builder;

@AllArgsConstructor
@Builder
public class Ticket {

    private long fee;

    public long getFee() {
        return fee;
    }
}
