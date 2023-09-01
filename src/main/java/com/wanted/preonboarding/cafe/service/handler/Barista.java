package com.wanted.preonboarding.cafe.service.handler;

import com.wanted.preonboarding.cafe.domain.Order;
import com.wanted.preonboarding.cafe.domain.Rank;
import com.wanted.preonboarding.cafe.domain.Status;
import java.util.List;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Barista {
    private Rank rank;
    private Status status;

    public String makeCoffeeTo(List<Order> orders){
        StringBuilder makeOrders = new StringBuilder();
        orders.forEach(order -> {
            makeOrders.append(order.getMenu())
                .append(":")
                .append(order.getCount());
        });
        return makeOrders.toString();
    }
}
