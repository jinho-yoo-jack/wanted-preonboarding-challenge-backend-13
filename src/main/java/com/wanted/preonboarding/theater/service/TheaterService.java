package com.wanted.preonboarding.theater.service;

import com.wanted.preonboarding.data.TheaterRequestDto;
import com.wanted.preonboarding.theater.service.handler.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TheaterService {
    private final Theater theater;

    /**
     * 관객 입장 처리 확인 메서드
     * @param theaterRequestDto 관객 입장 요청 정보
     * @return 관객 입장 처리 결과
     */
    public String enter(TheaterRequestDto theaterRequestDto) {
        // 관객 정보 생성
        Audience audience = new Audience(new Bag(
                theaterRequestDto.hasInvitation() ? new Invitation() : null,
                theaterRequestDto.getAmount()
        ));

        // 관객 입장 처리
        boolean result = theater.enter(audience);

        // 관객 입장 처리 결과 반환
        if (result) return "Have a good time.";
        return "Not enough money.";
    }
}
