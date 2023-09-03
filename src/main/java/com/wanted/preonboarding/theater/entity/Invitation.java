package com.wanted.preonboarding.theater.entity;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class Invitation {
    private LocalDateTime when;

    @Builder
    public Invitation(LocalDateTime when) {
        this.when = when;
    }
}
