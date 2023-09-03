package com.wanted.preonboarding.cafe.dto;

import com.wanted.preonboarding.cafe.entity.Menu;
import lombok.Builder;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Builder
public class OrderRequestDto {
    private int Americano;
    private int Latte;
    private int Espresso;

    public static Map<Menu, Integer> ofMap(OrderRequestDto dto) {
        Map<Menu, Integer> result = new HashMap<>();
        result.put(Menu.AMERICANO, dto.getAmericano());
        result.put(Menu.LATTE, dto.getLatte());
        result.put(Menu.ESPRESSO, dto.getEspresso());

        return result;
    }
}
