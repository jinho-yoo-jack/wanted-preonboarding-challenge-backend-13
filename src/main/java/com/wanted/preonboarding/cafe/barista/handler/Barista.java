package com.wanted.preonboarding.cafe.barista.handler;

import com.wanted.preonboarding.cafe.cafe.domain.Beverage;
import com.wanted.preonboarding.cafe.cafe.service.dto.OrderItem;

import java.util.List;
import java.util.Map;

public class Barista {
    private int rank; // 0: Beginner 1: Middle 2: Master
    private int status; // 0: Waiting 1: Making

    public Barista(int rank, int status){
        this.rank = rank;
        this.status = status;
    }

    private void setRank(int rank){
        this.rank = rank;
    }

    private void setStatus(int status){
        this.status = status;
    }

    public String makeCoffeeTo(Map<String, Integer> orders){
        StringBuilder makeOrders = new StringBuilder();
        for(String coffeeName : orders.keySet()){
            int quantity = orders.get(coffeeName);
            makeOrders.append(coffeeName)
                    .append(":")
                    .append(quantity);
        }
        return makeOrders.toString();
    }

    public String makeBeverageTo(List<OrderItem> orders) {
        return null;
    }


}
