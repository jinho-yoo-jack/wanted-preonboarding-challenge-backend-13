package com.wanted.preonboarding.cafe.service.handler;


import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Order {

    private final List<OrderItem> items;

    public Order(List<OrderItem> items) {
        this.items = items;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public long calculateTotalPrice(){
        return items.stream()
                .mapToLong(OrderItem::calculatePrice)
                .sum();
    }

}
