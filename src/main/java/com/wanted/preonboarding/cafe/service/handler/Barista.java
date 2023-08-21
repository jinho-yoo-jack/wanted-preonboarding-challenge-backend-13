package com.wanted.preonboarding.cafe.service.handler;

import lombok.Getter;

import java.util.Set;

@Getter
public class Barista {
    private Rank rank; // 0: Beginner 1: Middle 2: Master
    private Status status; // 0: Waiting 1: Making

    public Barista(Rank rank, Status status){
        this.rank = rank;
        this.status = status;
    }

    private void setRank(Rank rank){
        this.rank = rank;
    }

    private void setStatus(Status status){
        this.status = status;
    }

    public String makeCoffeeTo(Set<OrderMenu> orderMenuList) {
        StringBuilder makeOrders = new StringBuilder();
        for(OrderMenu coffeeMenu : orderMenuList){
            if (makeOrders.length() > 0) {
                makeOrders.append("\n");
            }
            makeOrders.append(coffeeMenu.getName())
                    .append(":")
                    .append(coffeeMenu.getQuantity());
        }
        return makeOrders.toString();
    }

}
