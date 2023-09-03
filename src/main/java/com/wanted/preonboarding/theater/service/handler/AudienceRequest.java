package com.wanted.preonboarding.theater.service.handler;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Optional;

@Data
@AllArgsConstructor
public class AudienceRequest {
    private Long amount;
    private InvitationRequest invitationInfo;

    public Audience convert2Audience() {
        Invitation invitation = null;
        if (invitationInfo != null) {
            invitation = new Invitation(invitationInfo.getWhen());
        }
        Bag bag = new Bag(invitation, amount);
        return new Audience(bag);
    }

}
