package com.wanted.preonboarding.domain.theater.application;

import static org.junit.jupiter.api.Assertions.*;

import com.wanted.preonboarding.domain.theater.dto.request.TheaterEnterDto;
import com.wanted.preonboarding.domain.theater.entity.Theater;
import java.time.LocalDateTime;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TheaterServiceTest {

  private final String ACCESS_MESSAGE = "Have a good time.";
  private final String CANT_ACCESS_MESSAGE = "Sorry you don't have enough money.";
  TheaterService theaterService = new TheaterService(new Theater());

  @Test
  @DisplayName("관객이 돈이 없어도, 티켓을 가지고 있으면 입장이 가능하다.")
  void should_enter_when_haveTicket() {
    TheaterEnterDto theaterEnterDto = new TheaterEnterDto(0L, 1000L, 2000L, null, true);
    Assertions.assertThat(theaterService.enter(theaterEnterDto)).isEqualTo(ACCESS_MESSAGE);
  }

  @Test
  @DisplayName("관객이 돈이 없어도, 입장권을 가지고 있으면 입장이 가능하다.")
  void should_enter_when_haveInvitation() {
    TheaterEnterDto theaterEnterDto = new TheaterEnterDto(0L, 1000L, 2000L,
        LocalDateTime.now().toString(),
        null);
    Assertions.assertThat(theaterService.enter(theaterEnterDto)).isEqualTo(ACCESS_MESSAGE);
  }

  @Test
  @DisplayName("관객이 돈이 충분하면, 티켓 구매 후 입장이 가능하다.")
  void should_enter_when_enoughAmount() {
    TheaterEnterDto theaterEnterDto = new TheaterEnterDto(2500L, 1000L, 2000L, null, null);
    Assertions.assertThat(theaterService.enter(theaterEnterDto)).isEqualTo(ACCESS_MESSAGE);
  }

  @Test
  @DisplayName("관객이 돈이 불충분하면, 티켓 구매 후 입장이 불가능하다.")
  void should_cantEnter_when_notEnoughAmount() {
    TheaterEnterDto theaterEnterDto = new TheaterEnterDto(0L, 1000L, 2000L, null, null);
    Assertions.assertThat(theaterService.enter(theaterEnterDto)).isEqualTo(CANT_ACCESS_MESSAGE);
  }
}