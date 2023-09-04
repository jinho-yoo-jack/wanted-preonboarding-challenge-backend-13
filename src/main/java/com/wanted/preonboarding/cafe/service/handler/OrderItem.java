package com.wanted.preonboarding.cafe.service.handler;

import lombok.Getter;

@Getter
public class OrderItem {
    private final String name;
    private final int quantity;

    public OrderItem(String name, int quantity) {
        if(!existsMenu(name))
            throw new RuntimeException(name +"은 존재하지 않는 음료 입니다.");

        this.name = name;
        this.quantity = quantity;
    }

    private boolean existsMenu(String name){
        return MenuBoard.hasMenu(name);
    }

    public String toCoffee(){
        return name+":"+quantity;
    }

    public long calculatePrice(){
        return (long) MenuBoard.getPrice(name) * quantity;
    }

}
