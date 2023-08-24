package com.wanted.preonboarding.theater.controller;

import com.wanted.preonboarding.theater.controller.dto.EnterDto;
import com.wanted.preonboarding.theater.service.TheaterService;
import com.wanted.preonboarding.theater.service.handler.Audience;
import com.wanted.preonboarding.theater.service.handler.Bag;
import com.wanted.preonboarding.theater.service.handler.Invitation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    public String enter(@RequestBody EnterDto enterDto){
        Audience audience = enterDtoToAudience(enterDto);
        return theaterService.enter(audience);
    }

    private Audience enterDtoToAudience(EnterDto enterDto) {
        if (enterDto.getWhen() == null) {
            return new Audience(new Bag(enterDto.getAmount()));
        } else {
            Invitation invitation = new Invitation(enterDto.getWhen());
            return new Audience(new Bag(invitation, enterDto.getAmount()));
        }
    }
}
