package com.wanted.preonboarding.cafe.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Order {
    private Drinks drinks;
    private int amount;

    public long getTotalPrice() {
        return drinks.getPrice() * amount;
    }
}
