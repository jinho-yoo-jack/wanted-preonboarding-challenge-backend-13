package com.wanted.preonboarding.theater.service.dto;

import com.wanted.preonboarding.theater.service.handler.Bag;
import com.wanted.preonboarding.theater.service.handler.Invitation;

import java.time.LocalDateTime;

public class TheaterEnterRequestDto {
    private boolean hasInvitation;
    private LocalDateTime invitationDate;
    private long amount;

    public TheaterEnterRequestDto() {
    }

    public TheaterEnterRequestDto(LocalDateTime invitationDate, long amount) {
        this.invitationDate = invitationDate;
        this.amount = amount;
    }

    private Invitation toInvitation() {
        return new Invitation(invitationDate);
    }
    public LocalDateTime getInvitationDate() {
        return this.invitationDate;
    }

    public Bag toBag() {
        return new Bag(toInvitation(), amount);
    }
}
