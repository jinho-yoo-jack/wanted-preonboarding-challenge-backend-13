package com.wanted.preonboarding.cafe.service.handler;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
public class Cafe {
    private final String name;
    private Long sales;

    private final HashMap<String,Long> menu;

    public Cafe(){
        this.name = "wantedCodingCafe";
        this.sales = 10000L;
        this.menu=new HashMap<>(){{
            put("AMERICANO",100L);
            put("CAPPUCCINO",200L);
            put("ESPRESSO",150L);
        }};
    }

    public Long getPriceAbout(String coffee) {
        return menu.get(coffee);
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
}
