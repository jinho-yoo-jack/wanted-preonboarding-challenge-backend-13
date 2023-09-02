package com.wanted.preonboarding.cafe.controller;

import com.wanted.preonboarding.cafe.dto.OrderRequest;
import com.wanted.preonboarding.cafe.service.CafeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cafe")
@RequiredArgsConstructor
class CafeController {
    private final CafeService cafeService;

    @GetMapping("hello")
    public String welcomeMessage() {
        return cafeService.greet();
    }

    @GetMapping("order")
    public String orderFromMenu(@RequestBody @Valid OrderRequest orderRequest) {
        String result = cafeService.orderFrom(orderRequest);
        return result;
    }
}
