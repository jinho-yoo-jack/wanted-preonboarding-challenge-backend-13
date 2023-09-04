package com.wanted.preonboarding.theater.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Invitation {
    public Invitation(LocalDateTime when) {
        this.when = when;
    }

    private LocalDateTime when;

    public static Invitation of(LocalDateTime invitationTime) {
        return Invitation.builder()
                .when(invitationTime)
                .build();
    }

    public LocalDateTime getWhen() {
        return when;
    }

}
