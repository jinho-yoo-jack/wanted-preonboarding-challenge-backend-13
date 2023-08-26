package com.wanted.preonboarding.cafe.service.handler;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class Cafe {
    private final String name;
    private Long sales; // 스프링 빈이 불변이 아닌 상태 값을 가져도 되는지 궁금함, 책에서 봤었는데 기억이 안 남
    private Cashier cashier;
    private Barista barista;

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
