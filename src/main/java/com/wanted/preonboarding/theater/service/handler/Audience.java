package com.wanted.preonboarding.theater.service.handler;

import com.wanted.preonboarding.exception.BadRequest;
import com.wanted.preonboarding.theater.domain.AudienceRequestDto;

public class Audience {
    private final Bag bag;

    public Audience(AudienceRequestDto audienceRequestDto) {
        Invitation invitation = audienceRequestDto.getWhen() != null ? new Invitation(audienceRequestDto.getWhen()) : null;
        long amount = audienceRequestDto.getAmount() != null ? audienceRequestDto.getAmount() : 0L;
        this.bag = new Bag(invitation, amount);
    }

    public long buy(Ticket t){
        return bag.hold(t);
    }
}
