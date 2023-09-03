package com.wanted.preonboarding.cafe.service;

import com.wanted.preonboarding.cafe.service.handler.Cafe;
import com.wanted.preonboarding.cafe.service.handler.Cashier;
import com.wanted.preonboarding.cafe.service.handler.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CafeService {
    private final Cafe wantedCafe;

    public String orderFrom(Customer customer) {
        Cashier cashier = new Cashier(wantedCafe);
        return customer.buyCoffee(cashier);
//        return wantedCafe.buyCoffee(customer, cashier);
    }
}
