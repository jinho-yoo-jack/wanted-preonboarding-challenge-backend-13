package com.wanted.preonboarding.cafe.service.handler;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Item {
    private Long id;
    private String name;
    private Integer stock ;
    private Integer price;

    public void minusStock(Integer amount) {
        this.stock -= amount;
    }

    public void plusStock(Integer amount) {
        this.stock += amount;

    }
}
