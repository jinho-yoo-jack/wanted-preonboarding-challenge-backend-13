package com.wanted.preonboarding.theater.dto;

import com.wanted.preonboarding.theater.service.handler.Audience;
import com.wanted.preonboarding.theater.service.handler.Bag;
import com.wanted.preonboarding.theater.service.handler.Invitation;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class AudienceRequest {
    private Long amount;
    private LocalDateTime when;

    public AudienceRequest(Long amount, LocalDateTime when) {
        this.amount = amount;
        this.when = when;
    }

    public Audience of() {
        if (when == null) {
            return new Audience(new Bag(amount));
        }
        return new Audience(new Bag(new Invitation(when), amount));
    }
}
