package com.wanted.preonboarding.cafe.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class OrderDto {
    private List<OrderItemDto> items = new ArrayList<>();
}
