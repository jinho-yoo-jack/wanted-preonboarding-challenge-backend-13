package com.wanted.preonboarding.cafe.service;

import com.wanted.preonboarding.cafe.service.handler.Cafe;
import com.wanted.preonboarding.cafe.service.handler.Cashier;
import com.wanted.preonboarding.cafe.service.handler.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class CafeService {
    private final Cafe wantedCafe;

    public String orderFrom(HashMap<String, Integer> myOrders) {
        Cashier cashier = new Cashier(wantedCafe);
        Customer c1 = new Customer("Card", myOrders);
        return c1.buyCoffee(cashier);
    }
}
