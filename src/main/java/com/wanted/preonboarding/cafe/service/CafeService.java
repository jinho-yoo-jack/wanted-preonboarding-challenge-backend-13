package com.wanted.preonboarding.cafe.service;

import com.wanted.preonboarding.cafe.service.handler.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CafeService {
    private final Cafe wantedCafe;

    public String orderFrom(Customer customer){
        if ( !customer.hasOrderMenu() ) {
            throw new RuntimeException("주문이 없습니다.");
        }
        Cashier cashier = new Cashier(wantedCafe.getMenuList());
        Long totalPrice = cashier.calculateTotalPrice(customer.getOrder().getOrderMenus());
        log.info("totalPrice :: {}", totalPrice);
        wantedCafe.plusSales(totalPrice);
        Barista barista = new Barista(Rank.BEGINNER, Status.WAITING);
        return barista.makeCoffeeTo(customer.getOrder().getOrderMenus());
    }
}
