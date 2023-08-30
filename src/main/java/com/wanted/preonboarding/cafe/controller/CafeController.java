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

    @PostMapping("order")
    public String orderFromMenu(@RequestBody List<MenuRequestDto> menuList){
        return cafeService.orderFrom(menuList);
    }
}
