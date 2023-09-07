package com.wanted.preonboarding.theater.service.handler;

import com.wanted.preonboarding.theater.dto.AudienceRequestDto;
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
    
    public static Audience of(AudienceRequestDto requestDto) {
        
        Bag bag = Bag.builder()
                .amount(requestDto.getAmount())
                .invitation(null)
                .build();
    
        return Audience.builder()
                .bag(bag)
                .build();
    }
}