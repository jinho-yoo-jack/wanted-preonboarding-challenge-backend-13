package com.wanted.preonboarding.theater.service.handler.consumer;

import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
public class Invitation {
    private LocalDateTime when;

    @Builder
    public Invitation(LocalDateTime when) {
        this.when = when;
    }

    public LocalDateTime getWhen() {
        return when;
    }
}
