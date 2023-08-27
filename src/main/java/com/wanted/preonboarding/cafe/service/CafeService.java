package com.wanted.preonboarding.cafe.service;

import com.wanted.preonboarding.cafe.service.handler.Cafe;
import com.wanted.preonboarding.cafe.service.handler.Cashier;
import com.wanted.preonboarding.cafe.service.handler.Customer;
import com.wanted.preonboarding.cafe.service.handler.Menu;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CafeService {


    public String orderFrom(Menu menu){
        Cafe cafe = new Cafe();
        Cashier cashier = new Cashier(cafe);
        Customer c1 = new Customer(menu.getPaymentMethod(), menu.getDrinks());

        return c1.buyCoffee(cashier);
    }
}
