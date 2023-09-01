package com.wanted.preonboarding.theater.controller;

import com.wanted.preonboarding.theater.request.AudienceRequest;
import com.wanted.preonboarding.theater.service.TheaterService;
import com.wanted.preonboarding.theater.service.handler.Audience;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/theater")
@RequiredArgsConstructor
public class TheaterController {
    private final TheaterService theaterService;

    @GetMapping("hello")
    public String welcomeMessage(){
        return "Welcome to The Wanted Theater";
    }

    @PostMapping("/enter")
    public String enter(@RequestBody AudienceRequest request) {
        Audience audience = new AudienceRequest().toAudience(request);
        return theaterService.enter(audience);
    }
}
