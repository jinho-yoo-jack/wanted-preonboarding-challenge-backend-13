package com.wanted.preonboarding.cafe.service.handler;

import lombok.Getter;

@Getter
public class OrderItem {
    private final Menu menu;
    private final int quantity;

    public OrderItem(String name, int quantity) {
        if(!Menu.exists(name))
            throw new RuntimeException(name +"은 존재하지 않는 음료 입니다.");

        this.menu = Menu.valueOf(name);
        this.quantity = quantity;
    }


    public String toCoffee(){
        return menu.getName()+":"+quantity;
    }

    public long calculatePrice(){
        return (long) menu.getPrice() * quantity;
    }

}
