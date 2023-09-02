package com.wanted.preonboarding.cafe.service;

import com.wanted.preonboarding.cafe.domain.Cafe;
import com.wanted.preonboarding.cafe.dto.OrderRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CafeService {
    private final Cafe wantedCafe;

    /**
     * 인사를 합니다.
     */
    public String greet() {
        return wantedCafe.welcomeMessage();
    }

    /**
     * 주문을 접수 받고 처리합니다.
     */
    public String orderFrom(OrderRequest orderRequest) {
        return wantedCafe.orderReception(orderRequest);
    }
}
