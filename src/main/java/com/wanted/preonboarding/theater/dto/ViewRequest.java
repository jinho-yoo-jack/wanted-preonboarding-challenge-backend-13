package com.wanted.preonboarding.theater.dto;

import com.wanted.preonboarding.theater.domain.Invitation;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ViewRequest {
    private Long amount;
    private boolean isInvitation;

    public void setInvitation(boolean invitation) {
        isInvitation = invitation;
    }
}
