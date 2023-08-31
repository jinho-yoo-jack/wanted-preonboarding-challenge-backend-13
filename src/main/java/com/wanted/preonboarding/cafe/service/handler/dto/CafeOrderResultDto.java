package com.wanted.preonboarding.cafe.service.handler.dto;


import com.wanted.preonboarding.cafe.service.handler.CafeOrder;
import com.wanted.preonboarding.cafe.service.handler.domain.Menu;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class CafeOrderResultDto {
    private List<CafeOrderItemResultDto> items;
    private long totalPrice;

    public static CafeOrderResultDto of(Map<Menu, Integer> menus, long totalPrice) {
        List<CafeOrderItemResultDto> items = menus.keySet()
                .stream()
                .map(key -> new CafeOrderItemResultDto(key.name(), menus.get(key), true))
                .toList();

        return new CafeOrderResultDto(items, totalPrice);
    }

    public static CafeOrderResultDto of(CafeOrder order) {
        List<CafeOrderItemResultDto> items = order.getItems()
                .stream()
                .map(CafeOrderItemResultDto::of)
                .toList();
        return new CafeOrderResultDto(items, order.getTotalPrice());
    }
}
