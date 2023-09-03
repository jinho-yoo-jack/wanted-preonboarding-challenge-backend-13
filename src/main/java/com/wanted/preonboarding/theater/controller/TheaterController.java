package com.wanted.preonboarding.theater.controller;

import com.wanted.preonboarding.cafe.service.CafeService;
import com.wanted.preonboarding.theater.service.TheaterService;
import com.wanted.preonboarding.theater.service.dto.AudienceDto;
import com.wanted.preonboarding.theater.service.handler.Audience;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/theater")
@RequiredArgsConstructor
public class TheaterController {
    private final TheaterService theaterService;

    @GetMapping("hello")
    public String welcomeMessage(){
        return "Welcome to The Wanted Theater";
    }

    @PostMapping("enter")
    public String enter(@RequestBody AudienceDto audienceDto){
        Audience audience = Audience.from(audienceDto);
        return theaterService.enter(audience);
    }
}
