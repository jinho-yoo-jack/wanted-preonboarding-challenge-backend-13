package com.wanted.preonboarding.theater.controller.request;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wanted.preonboarding.theater.service.dto.TheaterEnterRequestDto;
import java.io.Serializable;
import java.time.LocalDateTime;

public class TheaterEnterRequest {
    @JsonSerialize
    private LocalDateTime invitationDate;
    private long amount;

    public TheaterEnterRequest() {
    }

    public TheaterEnterRequest(LocalDateTime invitationDate, long amount) {
        this.invitationDate = invitationDate;
        this.amount = amount;
    }

    public TheaterEnterRequestDto toDto() {
        return new TheaterEnterRequestDto(invitationDate, amount);
    }
}
