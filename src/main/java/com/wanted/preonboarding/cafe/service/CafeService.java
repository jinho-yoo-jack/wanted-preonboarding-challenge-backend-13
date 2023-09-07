package com.wanted.preonboarding.cafe.service;

import com.wanted.preonboarding.cafe.service.handler.Cafe;
import com.wanted.preonboarding.cafe.service.handler.Cashier;
import com.wanted.preonboarding.cafe.service.handler.Customer;
import com.wanted.preonboarding.cafe.service.handler.Beverage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CafeService {
    private final Cafe wantedCafe;

    public String orderFrom(HashMap<String, Integer> menu){
        // 들어 온 주문에 따라서 적절한 `Beverage` 객체를 상속 받은 객체를 생성
        // Cashier 생성자 파라미터에 Barista 추가 필요
        Cashier cashier = new Cashier(wantedCafe);
        Map<Beverage, Integer> myOrders = new HashMap<>();
        myOrders.put(new Americano(), 3);
        Customer c1 = new Customer("Card", myOrders);
        return c1.buyCoffee(cashier);
    }
}
