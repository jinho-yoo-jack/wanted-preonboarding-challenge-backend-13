package com.wanted.preonboarding.theater.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wanted.preonboarding.theater.dto.enterRequest;
import com.wanted.preonboarding.theater.service.TheaterService;
import com.wanted.preonboarding.theater.service.handler.Audience;
import com.wanted.preonboarding.theater.service.handler.Bag;
import com.wanted.preonboarding.theater.service.handler.Invitation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Slf4j
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
    public String enter(@RequestBody enterRequest enterRequest) {
        Audience audience = createAudience(enterRequest);
        return theaterService.enter(audience);
    }

    private static Audience createAudience(enterRequest enterRequest) {
        LocalDateTime invitationCode = enterRequest.getInvitationCode();
        Invitation invitation = invitationCode != null ? new Invitation(invitationCode):null;
        Bag bag = new Bag(invitation, enterRequest.getAmount());
        return new Audience(bag);
    }
}