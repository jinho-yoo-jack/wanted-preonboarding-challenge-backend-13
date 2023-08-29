package com.wanted.preonboarding.cafe.controller;

import com.wanted.preonboarding.cafe.dto.CafeRequest;
import com.wanted.preonboarding.cafe.service.CafeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cafe")
@RequiredArgsConstructor
public class CafeController {
    private final CafeService cafeService;

    @GetMapping("hello")
    public String welcomeMessage(){
        return "Welcome to The Wanted coding cafe!!";
    }

    @PostMapping("order")
    public String orderFromMenu(@RequestBody CafeRequest cafeRequest){
        return cafeService.orderFrom(cafeRequest);
    }
}
