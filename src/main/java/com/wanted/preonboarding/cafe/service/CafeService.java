package com.wanted.preonboarding.cafe.service;

import com.wanted.preonboarding.cafe.domain.MenuRequestDto;
import com.wanted.preonboarding.cafe.service.handler.PaymentMethod;
import com.wanted.preonboarding.cafe.service.handler.Cafe;
import com.wanted.preonboarding.cafe.service.handler.Cashier;
import com.wanted.preonboarding.cafe.service.handler.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CafeService {
    private final Cafe wantedCafe;

    public String orderFrom(List<MenuRequestDto> menuList){
        HashMap<String, Integer> menu = getMenuHashMap(menuList);
        Cashier cashier = new Cashier(wantedCafe);
        Customer c1 = new Customer(PaymentMethod.CARD, menu);
        return c1.buyCoffee(cashier);
    }

    private HashMap<String, Integer> getMenuHashMap(List<MenuRequestDto> menuList) {
        HashMap<String, Integer> menu = new HashMap<String, Integer>();
        for (MenuRequestDto dto : menuList){
            menu.put(dto.getMenuName(), dto.getQuantity());
        }
        return menu;
    }
}
