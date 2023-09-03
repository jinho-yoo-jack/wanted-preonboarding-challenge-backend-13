package com.wanted.preonboarding.theater.controller;

import com.wanted.preonboarding.theater.RequestMessage;
import com.wanted.preonboarding.theater.domain.TicketSeller;
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
    private final TicketSeller ticketSeller;

    @GetMapping("hello")
    public String welcomeMessage() {
        return "Welcome to The Wanted Theater";
    }

    @GetMapping("enter")
    public String enter(RequestMessage requestMessage) {
        return theaterService.enter(requestMessage);
    }
}
