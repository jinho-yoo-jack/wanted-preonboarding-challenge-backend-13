package com.wanted.preonboarding.theater.entity;

import com.wanted.preonboarding.theater.dto.AudienceRequestDto;
import lombok.Builder;

public class Audience {
    private final Bag bag;

    @Builder
    public Audience(Bag bag) {
        this.bag = bag;
    }

    public Bag getBag() {
        return bag;
    }

    public static Audience of(AudienceRequestDto dto) {
        Bag bag = Bag.builder()
                .amount(dto.getMoney())
                .invitation((dto.getInvitationCreatedAt() != null) ?
                        Invitation.builder().when(dto.getInvitationCreatedAt()).build() :
                        null)
                .ticket((dto.getTicketPricePaid() != null) ?
                        Ticket.builder().fee(dto.getTicketPricePaid()).build() :
                        null)
                .build();

        return Audience.builder()
                .bag(bag)
                .build();
    }
}