package com.wanted.preonboarding.cafe.service.handler;

import com.wanted.preonboarding.cafe.dto.OrderRequestParam;
import com.wanted.preonboarding.cafe.enums.Menu;
import lombok.*;

import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Order {
    private Menu menu;
    private int quantity;

    public static List<Order> createOrderFrom(List<OrderRequestParam> menu) {
        return menu.stream()
                .map(Order::new)
                .toList();
    }

    public Order(OrderRequestParam menu) {
        this.menu = menu.getMenu();
        this.quantity = menu.getQuantity();
    }
}
