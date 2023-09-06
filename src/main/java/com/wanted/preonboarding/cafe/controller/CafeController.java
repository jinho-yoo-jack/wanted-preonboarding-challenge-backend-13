package com.wanted.preonboarding.cafe.controller;

import com.wanted.preonboarding.cafe.service.CafeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

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
    public String orderFromMenu() {
        HashMap<String, Integer> menu = new HashMap<String, Integer>();
        menu.put("AMERICANO", 3);
        return cafeService.orderFrom(menu);
    }
}
