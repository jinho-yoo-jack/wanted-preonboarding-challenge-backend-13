package com.wanted.preonboarding.cafe.service.handler;

import com.wanted.preonboarding.cafe.entity.Menu;
import com.wanted.preonboarding.cafe.entity.dto.OrderRequestParam;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class Order {
    private Map<String, Integer> orders;

    public static Order createOrder(List<OrderRequestParam> param) {
        Order order = new Order();
        Map<String, Integer> myOrders = new HashMap<>();

        param.stream().peek((menu) -> {
            myOrders.put(menu.getMenu().toString(), menu.getQuantity());
        });

        order.setOrders(myOrders);
        return order;
    }
}
