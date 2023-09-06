package com.wanted.preonboarding.cafe.entity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
public class Order {
    private Coffee coffee;
    private long quantity;

    public long getAmount(){
        return coffee.getPrice() * quantity;
    }
}
