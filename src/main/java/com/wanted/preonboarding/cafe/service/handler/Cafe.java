package com.wanted.preonboarding.cafe.service.handler;

import jakarta.annotation.PostConstruct;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Getter
public class Cafe {
    private final String name;
    private Long sales;
    private final Cashier cashier;

    public Cafe(){
        this.name = "wantedCodingCafe";
        this.sales = 10000L;
        this.cashier = new Cashier();
    }

    public void plusSales(Long amount){
        this.sales += amount;
    }

    public void minusSales(Long amount){
        this.sales -= amount;
    }

    public String makeCoffee(List<Order> receivedOrders, int baristaRank) {
        return cashier.takeOrder(receivedOrders, baristaRank);
    }
}
