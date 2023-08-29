package com.wanted.preonboarding.theater.service.dto;

import java.time.LocalDateTime;

public class TheaterEnterRequestDto {
    private boolean hasInvitation;
    private LocalDateTime invitationDate;
    private long amount;

    public TheaterEnterRequestDto() {
    }

    public TheaterEnterRequestDto(boolean hasInvitation, LocalDateTime invitationDate, long amount) {
        this.hasInvitation = hasInvitation;
        this.invitationDate = invitationDate;
        this.amount = amount;
    }

    public boolean hasInvitation() {
        return hasInvitation;
    }

    public LocalDateTime getInvitationDate() {
        return this.invitationDate;
    }

    public long getAmount() {
        return amount;
    }
}
