package com.wanted.preonboarding.audience.service.handler;

import java.time.LocalDateTime;

public class Invitation {
    private LocalDateTime when;

    public boolean isExpired(LocalDateTime now) {
        return when.isBefore(now);
    }
}
