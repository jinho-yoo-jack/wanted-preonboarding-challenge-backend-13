package com.wanted.preonboarding.cafe.service;

import com.wanted.preonboarding.cafe.dto.OrderRequestDto;
import com.wanted.preonboarding.cafe.entity.Menu;
import com.wanted.preonboarding.cafe.entity.PaymentMethod;
import com.wanted.preonboarding.cafe.handler.Cafe;
import com.wanted.preonboarding.cafe.handler.Cashier;
import com.wanted.preonboarding.cafe.handler.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CafeService {
    private final Cafe wantedCafe;

    public String orderFrom(OrderRequestDto menu){
        Cashier cashier = new Cashier(wantedCafe);
        Map<Menu, Integer> myOrders = OrderRequestDto.ofMap(menu);

        Customer c1 = new Customer(PaymentMethod.CARD, myOrders);
        return c1.buyCoffee(cashier);
    }
}
