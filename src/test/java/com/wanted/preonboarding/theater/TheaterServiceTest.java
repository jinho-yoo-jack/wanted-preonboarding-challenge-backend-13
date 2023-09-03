package com.wanted.preonboarding.theater;

import com.wanted.preonboarding.theater.dto.AudienceRequestDto;
import com.wanted.preonboarding.theater.service.TheaterService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TheaterServiceTest {
    @Autowired
    TheaterService theaterService;

    @Test
    @DisplayName("극장 입장")
    public void enter() {
        AudienceRequestDto dto = AudienceRequestDto.builder()
                .money(10000L)
                .build();

        AudienceRequestDto dto2 = AudienceRequestDto.builder()
                .money(10000L)
                .build();

        theaterService.enter(dto);
        theaterService.enter(dto2);
    }
}
