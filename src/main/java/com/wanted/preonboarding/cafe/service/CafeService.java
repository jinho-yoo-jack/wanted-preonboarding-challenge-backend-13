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
    private final PayCard payCard;
    private final PayCard payCash;


    /**
     * 주문 받기 및 가능한지 확인
     * @param orderRequest
     * @return
     */
    public void payOrderRequest(OrderRequest orderRequest){
        String paymentMethod = orderRequest.getPaymentMethod();
        long allPrice = wantedCafe.getCashier()
                                  .calculateTotalPrice(orderRequest);
        if ("현금".equals(paymentMethod)) {
            payCash.pay(allPrice);
        }if ("카드".equals(paymentMethod)) {
            payCard.pay(allPrice);
        }
        // 계산
        wantedCafe.plusSales(allPrice);
    }

    public boolean checkMakeCoffee(OrderRequest orderRequest) {
        return wantedCafe.canMakeCoffee(orderRequest.getBaristaRank());
    }

    public String makeCoffee(OrderRequest orderRequest) {
        return wantedCafe.makeCoffee(orderRequest);
    }
}
