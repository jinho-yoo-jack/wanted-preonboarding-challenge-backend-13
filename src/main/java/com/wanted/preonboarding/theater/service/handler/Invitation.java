package com.wanted.preonboarding.theater.service.handler;

import java.time.LocalDateTime;
import lombok.Getter;

@Getter
public class Invitation {
    private LocalDateTime when;

    public Invitation(LocalDateTime when) {
        this.when = when;
    }

    public boolean isValid() {
        return when != null;
    }
}
