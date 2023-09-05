package com.wanted.preonboarding.theater.service.handler;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.wanted.preonboarding.theater.exception.TheaterErrorCode;
import com.wanted.preonboarding.theater.exception.TheaterException;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class Invitation {

    @JsonProperty("when")
    private LocalDateTime when;
    @JsonProperty("isUsed")
    private boolean isUsed;


    public void modifyUsed() {
        isAlreadyUsed();
        this.isUsed = true;
    }

    // 초대권을 사용했는지, 유효기간이 지났는지 검증.
    public void verify() {
        isAlreadyUsed();
        isExpired();
    }

    private void isAlreadyUsed() {
        if (this.isUsed) {
            throw new TheaterException(TheaterErrorCode.INVITATION_ALREADY_USED);
        }
    }

    private void isExpired() {
        if (this.getWhen().isBefore(LocalDateTime.now())) {
            throw new TheaterException(TheaterErrorCode.INVITATION_EXPIRED);
        }
    }
}
