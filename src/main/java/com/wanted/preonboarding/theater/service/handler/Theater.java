package com.wanted.preonboarding.theater.service.handler;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class Theater {

    private List<Audience> list = new ArrayList<>();
    int count = 0;

    public void enter(Audience audience){
        list.add(audience);

        String ticketInfo = audience.getTicket().toString();
        log.info("ticketInfo : {}", ticketInfo);
        log.info("현재 관람객 수 : {}", list.size());
        log.info("관람객 리스트 : {}", list);
    }
}
