package com.wanted.preonboarding.cafe.service;

import com.wanted.preonboarding.cafe.OrderDto;
import com.wanted.preonboarding.cafe.service.handler.Cafe;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CafeService {
    private final Cafe wantedCafe;

    public String orderFrom(OrderDto orderDto){
        return wantedCafe.makeCoffee(orderDto.getOrderList(), orderDto.getBaristaRank()); // 커피 만들기
    }

    public Long pay(OrderDto orderDto) {
        Long total = wantedCafe.getCashier().calculateTotalPrice(orderDto.getOrderList());
        wantedCafe.plusSales(total);
        return total;
    }
}
