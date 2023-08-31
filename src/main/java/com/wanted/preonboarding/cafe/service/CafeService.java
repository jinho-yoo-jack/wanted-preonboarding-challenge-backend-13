package com.wanted.preonboarding.cafe.service;

import com.wanted.preonboarding.cafe.dto.OrderRequest;
import com.wanted.preonboarding.cafe.service.handler.Cafe;
import com.wanted.preonboarding.cafe.service.handler.Cashier;
import com.wanted.preonboarding.cafe.service.handler.Customer;
import com.wanted.preonboarding.cafe.service.handler.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CafeService {
    private final Cafe wantedCafe;

    public String orderFrom(OrderRequest request){
        Cashier cashier = new Cashier(wantedCafe);

        List<Order> orders = new ArrayList<>();
        List<OrderRequest.MenuDto> menus = request.getMenus();
        for (OrderRequest.MenuDto menu : menus) {
            orders.add(new Order(menu.getMenu(), menu.getCount()));
        }

        Customer c1 = new Customer(request.getPaymentMethod(), orders);
        return c1.buyCoffee(cashier);
    }
}
