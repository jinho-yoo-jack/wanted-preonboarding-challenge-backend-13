package com.wanted.preonboarding.cafe.service;

import com.wanted.preonboarding.cafe.dto.OrderRequest;
import com.wanted.preonboarding.cafe.service.handler.Cafe;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CafeService {
    private final Cafe wantedCafe;

    public String greet() {
        return wantedCafe.welcomeMessage();
    }

    public String orderFrom(OrderRequest orderRequest){
        return wantedCafe.orderReception(orderRequest);
    }
}
