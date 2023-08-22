package com.wanted.preonboarding.theater.audience.domain;

import java.time.LocalDateTime;

public class Invitation {
    private LocalDateTime when;

    public Invitation(LocalDateTime when) {
        this.when = when;
    }

    public Invitation() {
    }
}
