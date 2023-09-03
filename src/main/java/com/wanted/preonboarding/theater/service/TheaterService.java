package com.wanted.preonboarding.theater.service;

import com.wanted.preonboarding.theater.service.handler.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class TheaterService {
    private final Theater theater;

    public String enter(Audience audience){

        //초대권이 있는지
        if(audience.hasInvitation()) {
            Optional<Ticket> ticket = theater.checkInvitation(audience.getInvitation());
            if(ticket.isEmpty()) {
                log.info("입장 실패");
                return "초대권 날짜가 다릅니다.";
            }

            log.info("초대권 확인");

            audience.setTicket(ticket.get());
            return "Have a good time.";
        }

        if(!buyTicket(audience))
            return "티켓을 구매할 수 없습니다.";

        if (!theater.enter(audience))
            return "티켓이 없습니다.";

        return "Have a good time.";
    }

    public boolean buyTicket(Audience audience) {
        if(audience.getAmount() < theater.getTICKET_FEE()) {
            log.info("입장 실패");
            return false;
        }

        // 티켓 구매
        audience.setTicket(theater.sellTicket());
        audience.minusAmount(theater.getTICKET_FEE());
        log.info("티켓 구매");
        return true;
    }
}
