package com.wanted.preonboarding.theater.controller.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.wanted.preonboarding.theater.service.handler.Audience;
import com.wanted.preonboarding.theater.service.handler.Bag;
import com.wanted.preonboarding.theater.service.handler.Invitation;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@NoArgsConstructor
@ToString
@Getter
public class AudienceRequest {
    private Long amount;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime when;


    public Audience toAudience() {
        return new Audience(
                new Bag(
                        this.when == null ? null : new Invitation(this.when),
                        this.amount
                )
        );
    }
}
