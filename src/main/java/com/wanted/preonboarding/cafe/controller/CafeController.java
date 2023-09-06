package com.wanted.preonboarding.cafe.controller;

import com.wanted.preonboarding.cafe.domain.MenuRequestDto;
import com.wanted.preonboarding.cafe.service.CafeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/cafe")
@RequiredArgsConstructor
public class CafeController {
    private final CafeService cafeService;

    @GetMapping("hello")
    public String welcomeMessage(){
        return "Welcome to The Wanted coding cafe!!";
    }

    @GetMapping("test")
    public String test(){
        return "test";
    }

    @GetMapping("order")
    public String orderFromMenu(){
        HashMap<String, Integer> menu = new HashMap<String, Integer>();
        menu.put("AMERICANO", 3);
        return cafeService.orderFrom(menu);
    }
}
