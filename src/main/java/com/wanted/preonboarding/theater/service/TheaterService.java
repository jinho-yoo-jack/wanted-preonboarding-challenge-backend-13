package com.wanted.preonboarding.theater.service;

import com.wanted.preonboarding.theater.service.handler.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TheaterService {
    private final Theater theater;

    // 정상 실행되는 지 확인
    public String enter(){
        theater.enter(new Audience(new Bag(1000L)),
                new TicketSeller(new TicketOffice(20000L, new Ticket(100L))));
        return "Have a good time.";
    }
}
