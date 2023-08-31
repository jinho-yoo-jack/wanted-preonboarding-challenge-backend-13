package com.wanted.preonboarding.domain.theater.api;

import com.wanted.preonboarding.domain.theater.application.TheaterService;
import com.wanted.preonboarding.domain.theater.dto.request.TheaterEnterDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/theater")
@RequiredArgsConstructor
public class TheaterController {

  private final TheaterService theaterService;

  @GetMapping("hello")
  public String welcomeMessage() {
    return "Welcome to The Wanted Theater";
  }

  @GetMapping("/enter")
  public String enter(@RequestBody @Valid TheaterEnterDto reqDto) {
    return theaterService.enter(reqDto);
  }
}
