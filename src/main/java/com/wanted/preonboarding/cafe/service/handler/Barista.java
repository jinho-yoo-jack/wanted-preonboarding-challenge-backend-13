package com.wanted.preonboarding.cafe.service.handler;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
public class Barista {
    private int rank; // 0: Beginner 1: Middle 2: Master
    private int status; // 0: Waiting 1: Making

    public String makeCoffeeTo(List<Order> orders){
        StringBuilder makeOrders = new StringBuilder();
        setStatus(1);   // 만드는중

        for(Order order : orders){
            String coffeeName = order.getMenu().name();
            int quantity = order.getCount();
            makeOrders.append(coffeeName)
                    .append(":")
                    .append(quantity);
        }

        setStatus(0);   // 종료
        return makeOrders.toString();
    }


}
