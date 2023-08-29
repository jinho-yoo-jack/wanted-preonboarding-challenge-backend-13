package com.wanted.preonboarding.theater.service.handler;

import lombok.Builder;

import java.time.LocalDateTime;

public class Invitation {
    private LocalDateTime when;

    @Builder
    public Invitation(LocalDateTime when) {
        this.when = when;
    }
}
