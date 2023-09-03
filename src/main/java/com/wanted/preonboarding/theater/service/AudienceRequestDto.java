package com.wanted.preonboarding.theater.service;

import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AudienceRequestDto {

    private String ticket;
    private long amount;
    private String invitation;

}
