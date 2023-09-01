package com.wanted.preonboarding.cafe.service;

import com.wanted.preonboarding.cafe.dto.OrderRequest;
import com.wanted.preonboarding.cafe.service.handler.Cafe;
import com.wanted.preonboarding.cafe.service.handler.Cashier;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CafeService {
    private final Cafe wantedCafe;

    public String orderFrom(OrderRequest orderRequest){
        Cashier cashier = new Cashier(wantedCafe);

        return cashier.takeOrder(orderRequest);
    }
}
