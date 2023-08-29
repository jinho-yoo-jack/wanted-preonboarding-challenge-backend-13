package com.wanted.preonboarding.cafe.service;

import com.wanted.preonboarding.cafe.dto.CafeRequest;
import com.wanted.preonboarding.cafe.service.handler.Cafe;
import com.wanted.preonboarding.cafe.service.handler.Cashier;
import com.wanted.preonboarding.cafe.service.handler.Customer;
import com.wanted.preonboarding.cafe.service.handler.OrderTable;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CafeService {
    private final Cafe wantedCafe;

    public String orderFrom(CafeRequest cafeRequest){
        Cashier cashier = new Cashier(wantedCafe);
        OrderTable orderTable = new OrderTable(cafeRequest.getOrders());
        Customer c1 = new Customer("Card", orderTable);
        return c1.buyCoffee(cashier);
    }
}
