package com.wanted.preonboarding.cafe.dto;

import com.wanted.preonboarding.cafe.entity.Coffee;
import com.wanted.preonboarding.cafe.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerRequest {
    String coffeeName;
    long quantity;

    public Order toOrder(){
        return new Order(Coffee.findByName(coffeeName), quantity);
    }
}
