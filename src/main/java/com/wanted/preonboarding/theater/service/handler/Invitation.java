package com.wanted.preonboarding.theater.service.handler;

import java.time.LocalDateTime;

public class Invitation {
    private LocalDateTime when;

    public Invitation(LocalDateTime when) {
        this.when = when;
    }

    public static Invitation create(LocalDateTime invitationDateTime) {
        if (invitationDateTime == null) {
            return null;
        }
        return new Invitation(invitationDateTime);
    }
}
