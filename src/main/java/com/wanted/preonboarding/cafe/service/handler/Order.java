package com.wanted.preonboarding.cafe.service.handler;

import java.util.*;

public class Order {
    private final Map<Beverage, Integer> orderGroup;
    private int status; // 0: pending 1: processing 2: completed

    public Order(Map<Beverage, Integer> o, int s){
        this.orderGroup = o;
        this.status = s;
    }

    public Order(Map<Beverage, Integer> o){
        this(o, 0);
    }

    public Map<Beverage, Integer> getOrderDetailInfo(){
        return this.orderGroup;
    }

    public void changeOrderStatus(int orderStatus) {
        updateOrder(orderStatus);
    }

    private void updateOrder(int status) {
        this.status = status;
    }
}
