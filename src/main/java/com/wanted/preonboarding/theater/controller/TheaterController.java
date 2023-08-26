package com.wanted.preonboarding.theater.controller;

import com.wanted.preonboarding.theater.dto.AudienceInputDTO;
import com.wanted.preonboarding.theater.entity.Audience;
import com.wanted.preonboarding.theater.service.TheaterService;
import com.wanted.preonboarding.theater.service.handler.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/theater")
@RequiredArgsConstructor
public class TheaterController {
    private final TheaterService theaterService;
    private final Theater ticketTheaterImpl;
    private final Theater invitedTheaterImpl;

    @GetMapping("hello")
    public String welcomeMessage(){
        return "Welcome to The Wanted Theater";
    }

    @GetMapping("enter")
    public String enter(@RequestBody AudienceInputDTO audienceInputDTO){

        // DTO -> Entity
        Audience audience = audienceInputDTO.enterInfoDTOToAudience();

        // Use different theaterImpl by types of audience
        if(audienceInputDTO.getWhen() != null){
            return theaterService.enter(audience,invitedTheaterImpl);
        }
        return theaterService.enter(audience,ticketTheaterImpl);
    }

}
