package com.wanted.preonboarding.cafe.service.handler.dto;

import com.wanted.preonboarding.cafe.service.handler.CafeOrderItem;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class CafeOrderItemResultDto {
    private String menuName;
    private int quantity;
    private boolean isMade;

    public static CafeOrderItemResultDto of(CafeOrderItem item) {
        return new CafeOrderItemResultDto(
                item.getDrink().name(), item.getQuantity(), item.isMade()
        );
    }
}
