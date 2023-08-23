package com.wanted.preonboarding.theater.theater.controller;

import com.wanted.preonboarding.theater.theater.application.TheaterService;
import com.wanted.preonboarding.theater.theater.application.dto.RequestMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/theater")
@RequiredArgsConstructor
public class TheaterController {
    private final TheaterService theaterService;

    @GetMapping("/hello")
    public String welcomeMessage() {
        return "Welcome to The Wanted Theater";
    }

    @PostMapping("/enter")
    public String enter(@RequestBody RequestMessage request) {
        return theaterService.enter(request);
    }
}
