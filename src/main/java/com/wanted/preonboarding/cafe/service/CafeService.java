package com.wanted.preonboarding.cafe.service;

import com.wanted.preonboarding.cafe.service.handler.Cafe;
import com.wanted.preonboarding.cafe.service.handler.Cashier;
import com.wanted.preonboarding.cafe.service.handler.Customer;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CafeService {
    private final Cafe wantedCafe = new Cafe(100000L);

    public String orderFrom(HashMap<String, Integer> menu){
        Cashier cashier = new Cashier(wantedCafe);
        Map<String, Integer> myOrders = new HashMap<>();
        myOrders.put("AMERICANO", 3);
        Customer c1 = new Customer("Card", myOrders);
        return c1.buyCoffee(cashier);
    }
}
