package com.wanted.preonboarding.cafe.controller;

import com.wanted.preonboarding.cafe.service.CafeService;
import com.wanted.preonboarding.cafe.service.handler.Customer;
import com.wanted.preonboarding.cafe.service.handler.Orders;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/cafe")
@RequiredArgsConstructor
public class CafeController {
    private final CafeService cafeService;

    @GetMapping("hello")
    public String welcomeMessage() {
        return "Welcome to The Wanted coding cafe!!";
    }

    @PostMapping("order")
    public String orderFromMenu(@RequestBody OrderRequest request) {
        log.info("OrderRequest: {}", request);
        return cafeService.orderFrom(request.createCustomer());
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class OrderRequest {
        private String paymentMethod;
        private Map<String, Integer> orders = new HashMap<>();

        private Customer createCustomer() {
            return new Customer(getPaymentMethod(), createOrders());
        }

        private Orders createOrders() {
            return new Orders(orders);
        }
    }
}
