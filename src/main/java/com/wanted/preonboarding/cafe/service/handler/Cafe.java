package com.wanted.preonboarding.cafe.service.handler;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Cafe {
    private final String name;
    private final List<Menu> menus;
    private Long sales;

    public Cafe(){
        this.name = "wantedCodingCafe";
        this.sales = 10000L;
        this.menus = List.of(
                new Menu("아메리카노", 3500L),
                new Menu("카페라떼", 4000L),
                new Menu("카푸치노", 4500L),
                new Menu("아이스티", 3000L)
        );
    }

    public List<Menu> getMenuList() {
        return this.menus;
    }

    public void plusSales(Long amount){
        this.sales += amount;
    }

    public void minusSales(Long amount){
        this.sales -= amount;
    }
}
