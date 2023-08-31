package com.wanted.preonboarding.theater.controller;

import lombok.Getter;

@Getter
public class AudienceDTO {
    private final Long bagAmount;

    private final String invitation;

    public AudienceDTO(Long bagAmount) {
        this.bagAmount = bagAmount;
        this.invitation = null;
    }

    public AudienceDTO(Long bagAmount, String invitation) {
        this.bagAmount = bagAmount;
        this.invitation = invitation;
    }

    public Long getBagAmount() {
        return bagAmount;
    }

    public boolean hasInvitation() {
        return invitation != null;
    }

}
