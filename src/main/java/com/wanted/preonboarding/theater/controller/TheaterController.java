package com.wanted.preonboarding.theater.controller;

import com.wanted.preonboarding.theater.dto.AudienceInfo;
import com.wanted.preonboarding.theater.service.TheaterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import static com.wanted.preonboarding.theater.service.handler.Audience.*;

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
    public String enter(@RequestBody AudienceInfo request){

        return theaterService.enter(ofRequest(request));
    }
}
