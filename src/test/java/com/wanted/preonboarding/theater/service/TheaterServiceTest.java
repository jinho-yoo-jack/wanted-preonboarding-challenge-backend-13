package com.wanted.preonboarding.theater.service;

import static org.assertj.core.api.Assertions.*;

import com.wanted.preonboarding.theater.service.dto.TheaterEnterRequestDto;
import java.time.LocalDateTime;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TheaterServiceTest {

    @Autowired
    TheaterService theaterService;

    @Test
    @DisplayName("소극장에 입장하는 관객의 티켓을 확인하고, 만약 티켓이 없다면 구매 후, 입장을 시키고 티켓이 있다면 티켓 확인 후, 입장 시킨다.")
    void example() {
        // given

        // when

        // then
    }

    @Test
    @DisplayName("관객이 초대권을 소유하고 있다면, 극장에 입장시킨다.")
    void enter_invitation() {
        // given
        TheaterEnterRequestDto enterRequestDto = new TheaterEnterRequestDto(
                LocalDateTime.of(2023, 8, 30, 15, 0 ,0),
                15000
        );

        // when
        String enterMessage = theaterService.enter(enterRequestDto);

        // then
        assertThat(enterMessage).isEqualTo("Have a good time.");
    }

    @Test
    @DisplayName("초대권이 없는 관객은 티켓 구매 후, 극장에 입장시킨다.")
    void enter_no_invitation() {
        // given
        TheaterEnterRequestDto enterRequestDto = new TheaterEnterRequestDto(
                null,
                15000
        );

        // when
        String enterMessage = theaterService.enter(enterRequestDto);

        // then
        assertThat(enterMessage).isEqualTo("Have a good time.");
    }
}