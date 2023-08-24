package com.wanted.preonboarding.theater.controller;

import com.wanted.preonboarding.theater.dto.RequestMessage;
import com.wanted.preonboarding.theater.service.TheaterService;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public String enter(RequestMessage requestMessage) {
        return theaterService.enter(requestMessage);
    }
}
