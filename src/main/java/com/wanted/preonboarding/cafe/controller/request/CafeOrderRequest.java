package com.wanted.preonboarding.cafe.controller.request;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.wanted.preonboarding.cafe.service.handler.domain.Menu;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CafeOrderRequest {
    private List<CafeOrderItemRequest> items;

    public Map<String, Integer> toItemMap() {
        return items.stream()
                .collect(
                        Collectors.toMap(CafeOrderItemRequest::getMenuName, CafeOrderItemRequest::getQuantity)
                );
    }

    public Map<Menu, Integer> toOrderItemMap() {
        return items.stream()
                .collect(
                        Collectors.toMap(
                                cafeOrderItemRequest -> Menu.valueOf(cafeOrderItemRequest.getMenuName()),
                                CafeOrderItemRequest::getQuantity
                        )
                );
    }
}
