package com.wanted.preonboarding.cafe.cafe.service;

import com.wanted.preonboarding.cafe.barista.handler.Barista;
import com.wanted.preonboarding.cafe.cafe.service.dto.OrderItem;
import com.wanted.preonboarding.cafe.cafe.service.dto.OrderRequest;
import com.wanted.preonboarding.cafe.cafe.service.handler.Cafe;
import com.wanted.preonboarding.cafe.cashier.handler.Cashier;
import com.wanted.preonboarding.cafe.customer.handler.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CafeService {
    private static final int MAX_ORDER_BEVERAGE = 3;
    private static final String BEVERAGE_OVER_ORDER = "음료는 %s개 까지 주문이 가능합니다.";
    private static final String NOT_FOUND_CUSTOMER = "회원 정보가 없습니다.";
    private final Cafe wantedCafe;
    private final Cashier cashier = new Cashier(wantedCafe);
    private final Barista barista = new Barista(0, 0);

    public String orderFrom(HashMap<String, Integer> menu) {
        Cashier cashier = new Cashier(wantedCafe);
        Map<String, Integer> myOrders = new HashMap<>();
        myOrders.put("AMERICANO", 3);
        Customer c1 = new Customer("Card", myOrders);
        return c1.buyCoffee(cashier);
    }

    public String orderFrom(OrderRequest request) { // new
        validateOrderRequest(request);

        List<OrderItem> orderItems = request.getMenuList();

        cashier.purchase(orderItems);
        barista.makeBeverageTo(orderItems); //TODO: 여기서부터 해야됨.


        return null;
    }


    private void validateOrderRequest(OrderRequest request) {
        if (request.getCustomerId() < 1) {
            throw new IllegalArgumentException(NOT_FOUND_CUSTOMER);
        }
        List<OrderItem> menuList = request.getMenuList();
        long totalCount = menuList.stream()
                .map(OrderItem::getCount)
                .mapToLong(Long::longValue)
                .sum();
        if (request.getMenuList().size() > MAX_ORDER_BEVERAGE) {
            throw new IllegalArgumentException(String.format(BEVERAGE_OVER_ORDER, MAX_ORDER_BEVERAGE));
        }
    }
}
