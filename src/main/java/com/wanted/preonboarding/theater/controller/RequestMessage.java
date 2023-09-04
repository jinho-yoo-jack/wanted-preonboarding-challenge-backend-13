package com.wanted.preonboarding.theater.controller;


import com.wanted.preonboarding.theater.service.handler.Invitation;
import org.springframework.lang.Nullable;

import java.time.LocalDateTime;

// 관람객 정보
// 돈 액수, 티켓 정보(유무, 초대권 날짜)
public class RequestMessage {

    @Nullable
    private LocalDateTime invitationDate;

    private long amount;

    public RequestMessage(LocalDateTime invitationDate, long amount) {
        this.invitationDate = invitationDate;
        this.amount = amount;
    }

    public LocalDateTime getInvitationDate() {
        return invitationDate;
    }

    public long getAmount() {
        return amount;
    }
}
