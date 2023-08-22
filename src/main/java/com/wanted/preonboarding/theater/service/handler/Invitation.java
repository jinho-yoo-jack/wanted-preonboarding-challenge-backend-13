package com.wanted.preonboarding.theater.service.handler;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class Invitation {

    @JsonProperty("when")
    private LocalDateTime when;
    @JsonProperty("isUsed")
    private boolean isUsed;


    public void modifyUsed() {
        this.isUsed = !isUsed;
    }
}
