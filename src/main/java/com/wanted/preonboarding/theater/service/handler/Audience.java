package com.wanted.preonboarding.theater.service.handler;

import lombok.Builder;
import lombok.Getter;

@Getter
public class Audience {
    
    private final Bag bag;
    
    @Builder
    public Audience(Bag bag) {
        this.bag = bag;
    }
    
    /**
     * 티켓 구매 메서드
     *
     * @param ticket 구매할 티켓
     * @return 티켓 비용
     */
    public long buy(Ticket ticket) {
        return bag.buy(ticket);
    }
}