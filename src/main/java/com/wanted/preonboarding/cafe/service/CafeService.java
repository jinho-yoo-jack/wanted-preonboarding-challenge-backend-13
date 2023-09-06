package com.wanted.preonboarding.cafe.service;

import com.wanted.preonboarding.cafe.entity.Coffee;
import com.wanted.preonboarding.cafe.entity.Order;
import com.wanted.preonboarding.cafe.service.handler.Cafe;
import com.wanted.preonboarding.cafe.service.handler.Cashier;
import com.wanted.preonboarding.cafe.service.handler.Customer;
import lombok.RequiredArgsConstructor;
import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CafeService {
    private final Cafe wantedCafe;

    public String orderFrom(HashMap<String, Integer> menu){
        List<Order> orders = new ArrayList<>();
        for (String key : menu.keySet()) {
            Order order = new Order(Coffee.findByName(key), menu.get(key));
            orders.add(order);
        }
        Cashier cashier = new Cashier(wantedCafe);
        Customer c1 = new Customer("Card", orders);
        return c1.buyCoffee(cashier);
    }
}
