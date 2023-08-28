package com.wanted.preonboarding.theater.service.handler;

import lombok.AllArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
public class Invitation {
    private LocalDateTime when;

    public boolean isAvailable() {
        return LocalDateTime.now().isEqual(when);
    }

    public static Invitation createInvitation() {
        return new Invitation(LocalDateTime.now());
    }
}
