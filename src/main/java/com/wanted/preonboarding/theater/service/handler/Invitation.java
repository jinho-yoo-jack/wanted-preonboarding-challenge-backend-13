package com.wanted.preonboarding.theater.service.handler;

import java.time.LocalDateTime;

/**
 * 초대 정보
 */
public class Invitation {
    private int bagId; // 담긴 가방 아이디
    private LocalDateTime invitationDate; // 초대 날짜

    public Invitation (int bagId, LocalDateTime invitaionDate) {
        this.bagId = bagId;
        this.invitationDate = invitaionDate;
    }
    
    public int getBagId() {
        return bagId;
    }

    public LocalDateTime getInvitationDate() {
        return invitationDate;
    }
}
