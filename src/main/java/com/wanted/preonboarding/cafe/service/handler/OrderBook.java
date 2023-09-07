package com.wanted.preonboarding.cafe.service.handler;

import java.util.HashMap;
import java.util.UUID;

public class OrderBook {
    private static final HashMap<UUID, Order> orderForms = new HashMap<>();

    public void add(UUID u, Order o){
        orderForms.put(u, o);
    }
    public void remove(UUID u){
        orderForms.remove(u);
    }

    public Order getOrder(UUID u){
        return orderForms.get(u);
    }
}
