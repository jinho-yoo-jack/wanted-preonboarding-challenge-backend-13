package com.wanted.preonboarding.cafe.controller;

import com.wanted.preonboarding.cafe.service.CafeService;
import com.wanted.preonboarding.cafe.service.handler.*;
import com.wanted.preonboarding.global.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


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
        Customer customer = customerDto.toEntity();
        DiscountPolicy discountPolicy = DiscountPolicyFactory.createDiscountPolicyBy(customerDto.payment());
        Payment payment = PaymentFactory.createPayment(customerDto.payment(), customerDto.balance(), discountPolicy);
        customer.setPayment(payment);

        return Response.success(cafeService.orderFrom(customer));
    }
}
