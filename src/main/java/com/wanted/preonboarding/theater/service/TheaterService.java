package com.wanted.preonboarding.theater.service;

import com.wanted.preonboarding.theater.dto.AudienceDto;
import com.wanted.preonboarding.theater.dto.ResponseDto;
import com.wanted.preonboarding.theater.service.handler.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TheaterService {
    private final Theater theater;

    public ResponseDto enter(AudienceDto audience){
        Ticket ticket = theater.check();
        if (!audience.isInvitation()) { // 초대권 없으면
            audience = theater.sell(audience, ticket);
        }
        audience = theater.ticketing(audience);

        return new ResponseDto(audience.getAmount(), audience.isInvitation(), audience.isTicket(), "Have a good time");
    }
}