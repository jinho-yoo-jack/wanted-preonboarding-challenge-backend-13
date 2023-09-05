package com.wanted.preonboarding.theater.service.dto;

import com.wanted.preonboarding.theater.service.handler.Audience;
import com.wanted.preonboarding.theater.service.handler.Bag;
import com.wanted.preonboarding.theater.service.handler.Invitation;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@NoArgsConstructor
public class EnterTheaterRequest {

    private Long money;
    private String invitationTime;

    private void validation() {
        if(this.money == null) throw new IllegalArgumentException();
    }

    public Audience getAudience() {
        validation();
        Invitation invitation = null;
        Bag bag;

        if (invitationTime != null) {
            invitation = new Invitation(LocalDateTime.parse(invitationTime));
        }

        bag = new Bag(invitation, money);
        return new Audience(bag);
    }

}
