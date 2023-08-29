package com.wanted.preonboarding.theater.controller;

import com.wanted.preonboarding.theater.service.TheaterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.wanted.preonboarding.theater.service.handler.RequestMessage;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/theater")
@RequiredArgsConstructor
public class TheaterController {
    private final TheaterService theaterService;

    @GetMapping("hello")
    public String welcomeMessage(){
        return "Welcome to The Wanted Theater.";
    }

    @PostMapping("enter")
    public String enter(@RequestBody RequestMessage requestMessage){
        return theaterService.enter(requestMessage);
    }
}
