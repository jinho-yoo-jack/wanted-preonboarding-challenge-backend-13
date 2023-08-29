package com.wanted.preonboarding.theater.dto;

import com.wanted.preonboarding.theater.service.handler.Audience;
import com.wanted.preonboarding.theater.service.handler.Bag;
import com.wanted.preonboarding.theater.service.handler.Invitation;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
public class RequestMessage {
    private Long amount;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime when;


    public Audience toAudience() {
        return Audience.builder()
                .bag(Bag.builder()
                                .invitation(when == null ? null : Invitation.builder().when(when).build())
                                .amount(amount)
                                .build()
                )
                .build();
    }
}
