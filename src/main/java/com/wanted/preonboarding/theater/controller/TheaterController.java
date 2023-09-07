package com.wanted.preonboarding.theater.controller;

import com.wanted.preonboarding.theater.service.TheaterService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/theater")
@RequiredArgsConstructor
public class TheaterController {
    
    private final TheaterService theaterService;
    
    @GetMapping("hello")
    public String welcomeMessage() {
        return "Welcome to The Wanted Theater";
    }
    
    @GetMapping("enter")
    public String enter() {
        log.info("소극장 입장");
        return theaterService.enter();
    }
}
