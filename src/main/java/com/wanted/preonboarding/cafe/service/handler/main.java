package com.wanted.preonboarding.cafe.service.handler;

import java.util.HashMap;
import java.util.Map;

public class main {
    public static void main(String[] args) {
        Cafe caris = new Cafe(100000L);
        Cashier cashier = new Cashier(caris);
        Map<String, Integer> myOrders = new HashMap<>();
        myOrders.put("AMERICANO", 3);
        myOrders.put("LATTE", 2);
        Customer c1 = new Customer("Card", myOrders);
        String coffee = c1.buyCoffee(cashier);
        System.out.println(coffee);
    }
}
