package com.wanted.preonboarding.cafe;

import com.wanted.preonboarding.cafe.service.handler.Order;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderDto {
    private List<Order> orderList;
    private String payment;
    private int baristaRank;
}
