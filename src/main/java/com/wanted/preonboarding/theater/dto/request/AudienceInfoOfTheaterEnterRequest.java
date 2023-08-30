package com.wanted.preonboarding.theater.dto.request;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class AudienceInfoOfTheaterEnterRequest {
    private Long amount;
    private LocalDateTime invitationWhen;
}
