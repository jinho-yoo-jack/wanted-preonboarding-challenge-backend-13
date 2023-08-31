package com.wanted.preonboarding.theater.service.handler;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;

@AllArgsConstructor
@Builder
public class Invitation {
    private LocalDateTime when;
}
