package com.wanted.preonboarding.theater.service.handler;

import lombok.ToString;

import java.time.LocalDateTime;

@ToString
public class Invitation {
    private LocalDateTime when;

    public Invitation(LocalDateTime when) {
        this.when = when;
    }
}
