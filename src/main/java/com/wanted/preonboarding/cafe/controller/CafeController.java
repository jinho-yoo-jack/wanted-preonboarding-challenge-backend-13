package com.wanted.preonboarding.cafe.controller;

import com.wanted.preonboarding.cafe.dto.CustomerRequestDto;
import com.wanted.preonboarding.cafe.service.CafeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cafe")
@RequiredArgsConstructor
public class CafeController {
    public static final String WELCOME_MESSAGE = "Welcome to The Wanted coding cafe!!";
    private final CafeService cafeService;

    @GetMapping("hello")
    public String welcomeMessage() {
        return WELCOME_MESSAGE;
    }

    @GetMapping("order")
    public String orderFromMenu(@RequestBody CustomerRequestDto requestDto) {
        return cafeService.orderFrom(requestDto);
    }
}
