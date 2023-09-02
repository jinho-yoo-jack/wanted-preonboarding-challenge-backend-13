package com.wanted.preonboarding.cafe.controller;


import com.wanted.preonboarding.cafe.request.OrderRequest;
import com.wanted.preonboarding.cafe.service.CafeService;
import com.wanted.preonboarding.cafe.service.handler.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cafe")
@RequiredArgsConstructor
public class CafeController {
    private final CafeService cafeService;

    @GetMapping("hello")
    public String welcomeMessage() {
        return "Welcome to The Wanted coding cafe!!";
    }

    @PostMapping("/order")
    public String orderFromMenu(@RequestBody OrderRequest orderRequest) {
        Customer customer = new OrderRequest().toCustomer(orderRequest);
        return cafeService.orderFrom(customer);
    }
}
