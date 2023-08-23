package com.wanted.preonboarding.theater.controller;

import com.wanted.preonboarding.theater.dto.TheaterRequest;
import com.wanted.preonboarding.theater.dto.TheaterResponse;
import com.wanted.preonboarding.theater.service.TheaterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/theater")
@RequiredArgsConstructor
public class TheaterController {
    private final TheaterService theaterService;

    @GetMapping("hello")
    public String welcomeMessage(){
        return "Welcome to The Wanted Theater";
    }

    @GetMapping("enter")
    public TheaterResponse.Enter enter(TheaterRequest.Audience request){
        return theaterService.enter(request);
    }
}
