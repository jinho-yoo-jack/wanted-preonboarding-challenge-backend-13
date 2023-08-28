package com.wanted.preonboarding.theater.service.handler.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class RequestMessage {
    private Long amount;
    private boolean invitation;

    public boolean hasInvitation() {
        return this.invitation;
    }
}
