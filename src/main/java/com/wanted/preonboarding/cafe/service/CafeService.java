package com.wanted.preonboarding.cafe.service;

import com.wanted.preonboarding.cafe.service.handler.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class CafeService {

    private final Cafe cafe;

    public String orderFrom(CustomerDto customerDto){
        Customer customer = customerDto.of();
        Cashier cashier = new Cashier(cafe);
        Orders orders = customer.getMyOrders();
        long totalPrice = cashier.calculateTotalPrice(orders);


        return customer.getName()+"'s order [ " + customer.buyCoffee(cashier, totalPrice) + "] complete";
    }
}
