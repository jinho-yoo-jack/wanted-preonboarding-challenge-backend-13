package com.wanted.preonboarding.cafe.controller.request;

import com.wanted.preonboarding.cafe.service.handler.domain.Drink;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
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

    public Map<Drink, Integer> toOrderItemMap() {
        return items.stream()
                .collect(
                        Collectors.toMap(
                                cafeOrderItemRequest -> Drink.valueOf(cafeOrderItemRequest.getMenuName()),
                                CafeOrderItemRequest::getQuantity
                        )
                );
    }
}
