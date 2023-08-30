package com.wanted.preonboarding.cafe.service.handler;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class Cafe {
    private final String name;
    private Long sales;
    private HashMap<String, Integer> menus;

    public Cafe(){
        this.name = "wantedCodingCafe";
        this.sales = 10000L;
        this.menus = new HashMap<>();
        initialize_menus();
    }
    private void initialize_menus() {
        if (this.menus == null) return;
        menus.put("AMERICANO", 1500);
        menus.put("LATTE", 2000);
        menus.put("애지꾸 signature", 3200);
    }

    public String getCafeName(){
        return name;
    }

    public void plusSales(Long amount){
        this.sales += amount;
    }

    public void minusSales(Long amount){
        this.sales -= amount;
    }

    public Integer getPriceOf(String beverage) {
        return menus.get(beverage);
    }
}
