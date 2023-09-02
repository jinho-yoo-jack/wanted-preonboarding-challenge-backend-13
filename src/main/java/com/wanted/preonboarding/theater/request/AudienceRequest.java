package com.wanted.preonboarding.theater.request;

import com.wanted.preonboarding.theater.service.handler.Audience;
import com.wanted.preonboarding.theater.service.handler.Bag;
import com.wanted.preonboarding.theater.service.handler.Invitation;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class AudienceRequest {
    private Long amount;
    private LocalDateTime when;

    public Audience toAudience(final AudienceRequest audienceRequest) {
        if (audienceRequest.getWhen() == null) {
            return Audience.builder()
                    .bag(new Bag(audienceRequest.getAmount()))
                    .build();
        }

        return Audience.builder()
                .bag(new Bag(new Invitation(audienceRequest.getWhen()), audienceRequest.getAmount()))
                .build();
    }
}
