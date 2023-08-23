package com.wanted.preonboarding.theater.dto;

import com.wanted.preonboarding.theater.service.handler.Audience;
import com.wanted.preonboarding.theater.service.handler.Bag;
import com.wanted.preonboarding.theater.service.handler.Invitation;
import com.wanted.preonboarding.theater.service.handler.Ticket;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@ToString
public class RequestMessage {

//    private Invitation invitation = new Invitation(LocalDateTime.now());
    private Invitation invitation = null;
    private Ticket ticket = null;
    private Long amount = 1500L;

    public Bag toBag(){
        return Bag.builder()
                .amount(amount)
                .invitation(invitation)
                .ticket(ticket)
                .build();
    }

    public Audience toAudience(){
        return Audience.builder()
                .bag(toBag())
                .build();
    }

}
