package com.wanted.preonboarding.cafe.service.handler;

import com.wanted.preonboarding.cafe.exception.CafeErrorCode;
import com.wanted.preonboarding.cafe.exception.CafeException;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public record CustomerDto(String name, String payment, long balance, Map<String, Integer> orders) {

    public Customer toEntity() {
        if (name == null || payment == null || orders == null) {
            throw new CafeException(CafeErrorCode.ORDER_REQUEST_ERROR);
        }

        return new Customer(name,null, setOrders(orders));
    }

    public Orders setOrders(Map<String, Integer> orders) {
        List<Menu> menuList = Arrays.asList(Menu.values());
        boolean menuValid = orders.keySet()
                .stream()
                .allMatch(orderName -> menuList
                        .stream()
                        .anyMatch(menu -> menu.getName()
                                .equalsIgnoreCase(orderName)));
        if (!menuValid) {
            throw new CafeException(CafeErrorCode.MENU_NOT_FOUND);
        }

        return new Orders(orders.entrySet().stream()
                .collect(Collectors.toMap(
                        entry -> menuList.stream()
                                .filter(menu -> menu.getName().equalsIgnoreCase(entry.getKey()))
                                .findFirst()
                                .orElseThrow(),
                        Map.Entry::getValue)));
    }
}
