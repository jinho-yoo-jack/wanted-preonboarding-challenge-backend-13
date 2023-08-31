package com.wanted.preonboarding.cafe.controller;

import com.wanted.preonboarding.cafe.service.CafeService;
import com.wanted.preonboarding.cafe.service.handler.Customer;
import com.wanted.preonboarding.cafe.service.handler.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.Charset;
import java.util.Map;

@RestController
@RequestMapping("/cafe")
@RequiredArgsConstructor
public class CafeController {
    private final CafeService cafeService;
    private final CustomerService customerService;

    @GetMapping("hello")
    public String welcomeMessage() {
        return "Welcome to The Wanted coding cafe!!";
    }

    @PostMapping("order")
    public ResponseEntity<String> orderFromMenu(@RequestBody Map<String, Integer> menu) {
        Customer customer = customerService.createCustomer("cash", menu);
        String result = cafeService.orderFrom(customer)+ " 주문 완료!";
        HttpHeaders header = new HttpHeaders();
        header.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

        return new ResponseEntity<>(result, header, HttpStatus.OK);
    }
}
