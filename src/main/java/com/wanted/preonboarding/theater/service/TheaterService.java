package com.wanted.preonboarding.theater.service;

import com.wanted.preonboarding.theater.service.handler.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.wanted.preonboarding.theater.Client.RequestMessage;

@Service
@RequiredArgsConstructor
public class TheaterService {
    private final Theater theater;

    // 정상 실행되는 지 확인
    public String enter(){
        if(
            theater.enter(
                new RequestMessage(
                    new Audience(1000L),
                    new TicketOffice(20000L, new Ticket(100L))
                )
            )
        ) { // 100L짜리 티켓 하나 가진 TicketOffice
            return "Have a good time.";
        }
        return "You don't have pass for Movie.";
    }
}
