package com.wanted.preonboarding.cafe.service;

import com.wanted.preonboarding.cafe.entity.Order;
import com.wanted.preonboarding.cafe.exception.MenuOrderException;
import com.wanted.preonboarding.cafe.service.handler.Cafe;
import com.wanted.preonboarding.cafe.service.handler.Cashier;
import com.wanted.preonboarding.cafe.service.handler.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;



@Service
@RequiredArgsConstructor
public class CafeService {
    private final Cafe wantedCafe;

    public String orderFrom(Order order) throws MenuOrderException {
        // 캐시어 생성
        Cashier cashier = new Cashier(wantedCafe);
        // 고객 생성
        Customer c1 = new Customer("Card", order);
        // 고객 커피 주문 <- 캐시어 주입
        return c1.buyCoffee(cashier);
    }
}
