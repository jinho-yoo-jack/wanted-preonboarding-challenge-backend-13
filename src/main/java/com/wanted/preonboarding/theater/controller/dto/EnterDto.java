package com.wanted.preonboarding.theater.controller.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class EnterDto {
    private Long amount;
    private LocalDateTime when;
}
