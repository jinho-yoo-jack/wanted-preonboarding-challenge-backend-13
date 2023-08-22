package com.wanted.preonboarding.cafe.service;

import com.wanted.preonboarding.cafe.dto.CafeRequest;
import com.wanted.preonboarding.cafe.service.handler.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CafeService {
    private final Cafe wantedCafe;

    public String orderFrom(List<CafeRequest.Order> request){
        List<Order> orderList = request.stream().map(Order::create).toList();
        Cashier cashier = new Cashier(wantedCafe);
        Customer customer = new Customer("Card", orderList);
        Barista barista = new Barista(0, 0);

        long totalPrice = getOrderTotalPrice(orderList);
        cashier.takeOrder(totalPrice);
        String makeCoffeeTo = barista.makeCoffeeTo(orderList);

        return makeCoffeeTo +
            "totalPrice:" +
            totalPrice;
    }

    private static long getOrderTotalPrice(List<Order> orderList) {
        return orderList.stream().mapToLong(Order::getPrice).sum();
    }
}
