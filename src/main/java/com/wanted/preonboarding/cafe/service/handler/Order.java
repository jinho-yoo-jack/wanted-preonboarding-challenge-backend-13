package com.wanted.preonboarding.cafe.service.handler;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Order {

    private final Map<MenuItem, Integer> orders;
    private final MenuCalculable menuCalculable;

    private Order(Map<MenuItem, Integer> orders, MenuCalculable menuCalculable) {
        this.orders = orders;
        this.menuCalculable = menuCalculable;
    }

    public static Order create(Map<MenuItem, Integer> orders, MenuCalculable menuCalculable) {
        return new Order(orders, menuCalculable);
    }

    public long calculateTotalPrice() {
        return menuCalculable.calculate(orders);
    }

    public MadeCoffeeMap makeCoffee() {
        Map<MenuItem, List<Coffee>> map = orders.entrySet().stream()
                .collect(Collectors.toMap(
                        entry -> entry.getKey(),
                        entry -> createCoffeeList(entry.getKey(), entry.getValue())
                ));
        return new MadeCoffeeMap(map);
    }

    private List<Coffee> createCoffeeList(MenuItem menuItem, Integer orderAmount) {
        List<Coffee> result = new ArrayList<>();
        for (int i=0;i<orderAmount;i++) {
            result.add(Coffee.create(menuItem));
        }
        return result;
    }

}
