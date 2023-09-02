package com.wanted.preonboarding.cafe.domain;

import com.wanted.preonboarding.cafe.dto.OrderRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Getter
@Builder
public class Cafe {
    private final String name;
    private Long sales;
    private Barista barista;
    private Cashier cashier;

    public String welcomeMessage() {
        return String.format("Welcome to The %s!!", name);
    }

    public void plusSales(Long amount){
        this.sales += amount;
    }

    public void minusSales(Long amount){
        this.sales -= amount;
    }

    /**
     * 카페에 주문이 접수 됨
     */
    public String orderReception(OrderRequest orderRequest) {
        plusSales(cashier.calculateTotalPrice(orderRequest.getOrder()));

        return cashier.sendTo(barista, orderRequest.getOrder());
    }
}
