package com.wanted.preonboarding.theater.service.handler;

import static lombok.AccessLevel.PROTECTED;

import java.time.LocalDateTime;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = PROTECTED)
public class Invitation {
    
    private final LocalDateTime when = LocalDateTime.now();
}
