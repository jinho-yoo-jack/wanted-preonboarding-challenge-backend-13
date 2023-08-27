package com.wanted.preonboarding.theater.service;

import com.wanted.preonboarding.theater.service.handler.*;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TheaterService {
    private final Theater theater;
    
    //판매원이 배치된 theater 생성
    @Autowired
    public TheaterService(TicketSeller ticketSeller) {
    	this.theater = new Theater(ticketSeller);
    }

    public String enter(RequestMessage requestMessage) {
        Audience audience = new Audience(new Bag(requestMessage.getInvitation(), requestMessage.getAmount()));
        
        //티켓 판매
        theater.getTicketSeller().ticketing(audience);
        
        //티켓 검증
        audience.enterTheater(theater);
        return "즐거운 시간 되십시오";
    }
}
