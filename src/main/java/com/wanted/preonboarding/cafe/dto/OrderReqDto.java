package com.wanted.preonboarding.cafe.dto;

import com.wanted.preonboarding.cafe.entity.Drinks;
import com.wanted.preonboarding.cafe.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Setter
public class OrderReqDto {
    private String drinks;
    private int amount;

    public Order toEntity(Drinks drinks) {
        return new Order(drinks, amount);
    }
}
