package com.wanted.preonboarding.cafe.service.impl;

import com.wanted.preonboarding.cafe.dto.request.RequestMenu;
import com.wanted.preonboarding.cafe.service.CafeService;
import com.wanted.preonboarding.cafe.service.handler.Barista;
import com.wanted.preonboarding.cafe.service.handler.Cafe;
import com.wanted.preonboarding.cafe.service.handler.Cashier;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class CafeServiceImpl implements CafeService {

    private final Cafe wantedCafe;
    private Map<String, Long> menu = Map.of("AMERICANO", 100L, "LATTE", 1000L, "HOTCHOCO", 100L);

    @Override
    public String orderFrom(RequestMenu requestMenu) {
        Cashier cashier = new Cashier(wantedCafe);
        wantedCafe.plusSales(cashier.calculateTotalPrice(requestMenu.getOrderList(), menu));

        Barista barista = new Barista(0, 0);
        return barista.makeCoffeeTo(requestMenu.getOrderList());

    }

    @Override
    public Long getMenuPrice(String name) {
        return menu.get(name);
    }

}
