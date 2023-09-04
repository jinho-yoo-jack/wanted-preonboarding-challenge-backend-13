package com.wanted.preonboarding.cafe.service;

import com.wanted.preonboarding.cafe.controller.Order;
import com.wanted.preonboarding.cafe.service.handler.Barista;
import com.wanted.preonboarding.cafe.service.handler.Cafe;
import com.wanted.preonboarding.cafe.service.handler.Cashier;
import com.wanted.preonboarding.cafe.service.handler.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CafeService {

    private final Cafe wantedCafe;

    public String orderFrom(final List<Order> orderList, final String paymentType){

        HashMap<String, Integer> orders = getOrders(orderList);

        // 손님
        Customer c = new Customer(paymentType, orders);

        // 카페 차림
        Cashier cashier = new Cashier();
        Barista barista = new Barista(0, 0);
        wantedCafe.plusBaristas(barista);
        wantedCafe.plusCashier(cashier);

        // 돈 계산
        long totalPrice = cashier.calculateTotalPrice(orders, wantedCafe);
        wantedCafe.plusSales(totalPrice);

        // 음료 제작
        List<Barista> baristas = wantedCafe.getBaristas();
        Barista barista1 = choiceBarista(baristas);
        if (baristas != null) {
            String result = barista1.makeCoffeeTo(orders);
            return result;
        }
        else { // 바리스타 없음
            wantedCafe.minusSales(totalPrice);
            return "wait";
        }
    }

    private static HashMap<String, Integer> getOrders(List<Order> orderList) {
        HashMap<String, Integer> orders = new HashMap<>();
        for (Order o: orderList) {
            String menu = o.getMenu();
            Integer quantity = o.getQuantity();
            orders.put(menu, quantity);
        }
        return orders;
    }

    public Barista choiceBarista(List<Barista> baristas) {
        for (Barista b:baristas) {
            if (b.getStatus()==0) {
                return b;
            }
        }
        return null;
    }
}
