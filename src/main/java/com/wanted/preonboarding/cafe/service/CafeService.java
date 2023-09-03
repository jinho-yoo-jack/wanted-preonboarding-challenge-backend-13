package com.wanted.preonboarding.cafe.service;

import com.wanted.preonboarding.cafe.CafeOrderRequest;
import com.wanted.preonboarding.cafe.domain.Cafe;
import com.wanted.preonboarding.cafe.domain.OrderMenu;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CafeService {
    private final Cafe wantedCafe;

    public String orderFrom(CafeOrderRequest request) {
        final List<OrderMenu> orderMenus = mapToOrderMenu(request);

        wantedCafe.takeOrder(orderMenus);

        return wantedCafe.sendTo(orderMenus);
    }

    private static List<OrderMenu> mapToOrderMenu(CafeOrderRequest request) {
        if (request.orders() == null) {
            throw new IllegalArgumentException("주문한 메뉴가 없습니다.");
        }

        return request.orders()
                .entrySet()
                .stream()
                .map((entry) -> OrderMenu.from(entry.getKey(), entry.getValue()))
                .toList();
    }
}
