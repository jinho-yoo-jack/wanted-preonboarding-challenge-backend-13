package com.wanted.preonboarding.cafe.service;

import com.wanted.preonboarding.cafe.service.handler.Cafe;
import com.wanted.preonboarding.cafe.service.handler.CafeOrder;
import com.wanted.preonboarding.cafe.service.handler.Cashier;
import com.wanted.preonboarding.cafe.service.handler.Customer;
import com.wanted.preonboarding.cafe.service.handler.domain.Drink;
import com.wanted.preonboarding.cafe.service.handler.domain.PaymentMethod;
import com.wanted.preonboarding.cafe.service.handler.dto.CafeOrderResultDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class CafeService {
    private final Cafe wantedCafe;

    public CafeOrderResultDto orderFrom(Map<Drink, Integer> menu){
        // wantedCafe 에서 주문을 받는다 -> 고객한테
        // wantedCafe.receivedOrderOf(customer)
        // 이러면 wantedCafe 내에서 cashier 와 barista 를 생성해서 처리하는
        // 도메인 서비스 역할...?
        // 그러기엔 cafe 객체에 총액이 필드로 존재하는데
        // cafe 는 도메인 서비스보단 도메인 으로 봐야할 듯 하다.

        Customer customer = new Customer(PaymentMethod.CARD, menu);
        CafeOrder cafeOrder = wantedCafe.receivedOrderOf(customer);

        return CafeOrderResultDto.of(cafeOrder);
    }
}
