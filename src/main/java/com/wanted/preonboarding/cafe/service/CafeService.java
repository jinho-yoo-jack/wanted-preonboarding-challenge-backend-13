package com.wanted.preonboarding.cafe.service;

import com.wanted.preonboarding.cafe.service.handler.Cafe;
import com.wanted.preonboarding.cafe.service.handler.Cashier;
import com.wanted.preonboarding.cafe.service.handler.Coffee;
import com.wanted.preonboarding.cafe.service.handler.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.print.attribute.standard.MediaSize.Other;

@Service
@RequiredArgsConstructor
public class CafeService {
    private final Cafe wantedCafe;

    /**
     * 메뉴목록을 획득하는 서비스
     * @return
     */
    public static List<Coffee> getMenus() {
        List<Coffee> menus = new ArrayList<Coffee>();
        menus.add(new Coffee(1, "AMERICANO", 3));
        menus.add(new Coffee(2, "LATTE", 2));
        menus.add(new Coffee(3, "JUICE", 1));

        return menus;
    }

    public String orderFrom(Coffee coffee) {
        var menus = this.getMenus();
        Cashier cashier = new Cashier(wantedCafe);
        Map<String, Integer> myOrders = new HashMap<>();

        // 커피 주문
        var optOrderCoffee = menus.stream().filter(x -> x.getCoffeeId() == coffee.getCoffeeId()).findFirst();
        if (optOrderCoffee == null) return "잘못된 커피를 주문하였습니다.";

        var orderCoffee = optOrderCoffee.get();
        myOrders.put(orderCoffee.getCoffeeName(), orderCoffee.getCoffeeId());
        Customer c1 = new Customer("Card", myOrders);
        return c1.buyCoffee(cashier);
    }
}
