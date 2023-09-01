package com.wanted.preonboarding.theater.service;

import com.wanted.preonboarding.theater.service.handler.*;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TheaterService {
    
	@Autowired
	private final Theater theater;
    

    public String enter(RequestMessage requestMessage) {
        Audience audience = new Audience(new Bag(requestMessage.getInvitation(), requestMessage.getAmount()));
        
        //티켓 판매
        theater.ticketing(audience);
        
        //티켓 검증
        audience.enterTheater(theater);
        return "즐거운 시간 되십시오";
    }
}
