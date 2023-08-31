package com.wanted.preonboarding.cafe.service;

import com.wanted.preonboarding.cafe.service.handler.Cafe;
import com.wanted.preonboarding.cafe.service.handler.CafeOrder;
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
        Customer customer = new Customer(PaymentMethod.CARD, menu);
        CafeOrder cafeOrder = wantedCafe.receivedOrderOf(customer);

        return CafeOrderResultDto.of(cafeOrder);
    }
}
