package com.wanted.preonboarding.theater.controller;

import com.wanted.preonboarding.global.Response;
import com.wanted.preonboarding.theater.service.TheaterService;
import com.wanted.preonboarding.theater.service.handler.AudienceDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/theater")
@RequiredArgsConstructor
public class TheaterController {
    
    private final TheaterService theaterService;

    @GetMapping("/hello")
    public Response<String> welcomeMessage(){
        return Response.success("Welcome to The Wanted Theater");
    }

    @PostMapping("/enter")
    public Response<String> enter(@RequestBody AudienceDto audience) {
        String result = theaterService.enter(audience);
        return Response.success(result);
    }

    @PostMapping("/refund")
    public Response<String> refund(@RequestBody AudienceDto audience) {
        String result = theaterService.refund(audience);
        return Response.success(result);
    }
}
