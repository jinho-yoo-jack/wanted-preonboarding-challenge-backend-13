package com.wanted.preonboarding.theater.service.handler;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class Theater {

    public void enter(Audience audience){
        if ( audience == null || !audience.hasTicket() ) {
            throw new RuntimeException("입장할 수 없습니다.");
        }
        log.info("audience :: {}", audience);
    }
}
