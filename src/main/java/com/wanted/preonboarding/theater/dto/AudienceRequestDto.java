package com.wanted.preonboarding.theater.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AudienceRequestDto {
    private Long amount;
    private boolean invitation;
}
