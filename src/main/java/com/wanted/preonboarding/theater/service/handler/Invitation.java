package com.wanted.preonboarding.theater.service.handler;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class Invitation {
    private LocalDateTime when;
}
