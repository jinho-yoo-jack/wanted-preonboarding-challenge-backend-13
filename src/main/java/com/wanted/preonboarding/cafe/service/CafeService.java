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

    public String orderFrom(List<OrderMenu> menuList){
        Cashier cashier = new Cashier(wantedCafe);
        Customer c1 = new Customer("Card", menuList);   // "Card"도 PayMethod enum으로 변경
        return c1.buyCoffee(cashier);
    }
}
