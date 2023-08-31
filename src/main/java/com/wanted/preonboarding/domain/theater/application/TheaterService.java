package com.wanted.preonboarding.domain.theater.application;

import com.wanted.preonboarding.domain.theater.dto.request.TheaterEnterDto;
import com.wanted.preonboarding.domain.theater.entity.Theater;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TheaterService {

  private final String ACCESS_MESSAGE = "Have a good time.";
  private final String CANT_ACCESS_MESSAGE = "Sorry you don't have enough money.";

  private final Theater theater;

  public String enter(TheaterEnterDto reqDto) {
    if (theater.enter(reqDto.toAudience(), reqDto.toTicketSeller())) {
      return ACCESS_MESSAGE;
    }
    return CANT_ACCESS_MESSAGE;
  }
}
