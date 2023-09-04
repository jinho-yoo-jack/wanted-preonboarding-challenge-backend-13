package com.wanted.preonboarding.cafe.dto;

import lombok.Data;

@Data
public class OrderItemDto {
    private final String name;
    private final int quantity;

    public OrderItemDto(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }
}
