package com.wanted.preonboarding.cafe.controller;

import com.wanted.preonboarding.cafe.service.CafeService;
import com.wanted.preonboarding.cafe.service.handler.CustomerDto;
import com.wanted.preonboarding.global.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/cafe")
@RequiredArgsConstructor
public class CafeController {

    private final CafeService cafeService;

    @GetMapping("/hello")
    public Response<String> welcomeMessage() {
        return Response.success("Welcome to The Wanted coding cafe!!");
    }

    @PostMapping("/orders")
    public Response<String> orderFromMenu(@RequestBody CustomerDto customerDto) {
        return Response.success(cafeService.orderFrom(customerDto));
    }
}
