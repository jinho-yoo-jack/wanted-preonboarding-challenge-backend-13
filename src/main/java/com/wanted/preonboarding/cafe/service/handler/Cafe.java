package com.wanted.preonboarding.cafe.service.handler;

import com.wanted.preonboarding.exception.BadRequest;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class Cafe {
    private final String name;
    private Long sales;

    private Map<String, Long> menus;
    private Kitchen kitchen;

    public Cafe(){
        this.name = "wantedCodingCafe";
        this.sales = 10000L;
        this.menus = new HashMap<>();
        addMenus();
        this.kitchen = new Kitchen(new Barista(0, 0));
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

    public Long getSales(){
        return sales;
    }

    public void addMenu(String name, long price){
        menus.put(name, price);
    }

    public void removeMenu(String name){
        menus.remove(name);
    }

    public Long getMenuPrice(String name){
        if(menus.get(name) == null){
            throw new BadRequest("메뉴가 존재하지 않습니다.");
        }
        return menus.get(name);
    }

    public void addMenus(){
        menus.put("AMERICANO", 100L);
        menus.put("ICE_TEA", 100L);
        menus.put("LATTE", 200L);
    }

    public Kitchen getKitchen(){
        return kitchen;
    }

}
