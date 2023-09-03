package com.wanted.preonboarding.cafe.handler;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class Cafe {
    private final String name;
    private Long sales;

    public Cafe(){
        this.name = "wantedCodingCafe";
        this.sales = 10000L;
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
