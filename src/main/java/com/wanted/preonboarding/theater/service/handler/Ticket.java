package com.wanted.preonboarding.theater.service.handler;

import lombok.AllArgsConstructor;
import lombok.Builder;

@AllArgsConstructor
@Builder
public class Ticket {

    private Long fee;

    public Long getFee() {
        return fee;
    }
}
