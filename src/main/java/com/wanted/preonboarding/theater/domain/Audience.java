package com.wanted.preonboarding.theater.domain;

import com.wanted.preonboarding.theater.dto.AudienceRequest;
import lombok.Builder;

@Builder
public class Audience {
    private final Bag bag;

    public Audience(Bag bag){
        this.bag = bag;
    }

    public static Audience of(AudienceRequest audienceRequest) {
        return Audience.builder()
                .bag(Bag.builder()
                        .amount(audienceRequest.getBagAmount())
                        .invitation(Invitation.of(audienceRequest.getInvitationTime()))
                        .build())
                .build();
    }

    public Bag getBag(){ return bag;}

    public boolean hasInvitation() {
        return bag.hasInvitation();
    }

    public void takeTicket(Ticket ticket) {
        bag.setTicket(ticket);
    }

    public void buyTicket(Ticket ticket) {
        bag.minusAmount(ticket.getFee());
    }
}