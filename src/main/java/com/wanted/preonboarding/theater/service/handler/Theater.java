package com.wanted.preonboarding.theater.service.handler;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * 극장 클래스
 */
@Component
@RequiredArgsConstructor
public class Theater {
    private final TicketSeller ticketSeller;

    /**
     * 관객 입장 전 티켓 확인 메서드
     * @param audience 관객
     * @return 관객 입장 전 처리 결과
     */
    public boolean enter(Audience audience){
        return ticketSeller.checkTicket(audience);
    }
}
