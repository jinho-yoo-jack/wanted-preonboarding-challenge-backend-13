package com.wanted.preonboarding.theater.dto;

import com.wanted.preonboarding.theater.service.handler.Invitation;
import lombok.Getter;

@Getter
public class RequestMessage {
    private Long amount;
    private Invitation invitation;
}
