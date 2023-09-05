package com.wanted.preonboarding.cafe.service;

import com.wanted.preonboarding.cafe.service.handler.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@RequiredArgsConstructor
@Transactional
@Service
public class CafeService {

    private final Cafe cafe;

    public String orderFrom(CustomerDto customerDto){
        Customer customer = customerDto.toEntity();
        Orders orders = customer.getMyOrders();
        Cashier cashier = cafe.findAvailableCashier();
        cashier.takeOrder(cafe, orders);
        Barista barista = cafe.findAvailableBarista();
        return customer.getName()+"'s order [ " + barista.makeCoffeeTo(orders) + "] complete";
    }
}
