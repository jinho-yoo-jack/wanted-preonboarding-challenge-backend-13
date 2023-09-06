package com.wanted.preonboarding.cafe.service.handler;

import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.logging.Logger;

@Component
public class Cafe {
    private static final Logger logger = Logger.getGlobal();
    private final String name;
    private Long sales;

    public Cafe(){
        this.name = "wantedCodingCafe";
        this.sales = 10000L;
    }

    public String getCafeName(){
        return name;
    }

    private void plusSales(Long amount){
        this.sales += amount;
        logger.info("sales = " + this.sales);
    }

    private void minusSales(Long amount){
        this.sales -= amount;
    }

    public String sellBeverage(Cashier cashier, Map<Drink, Integer> receivedOrders) {
        plusSales(cashier.calculateTotalPrice(receivedOrders));
        return cashier.takeOrder(receivedOrders);
    }
}
