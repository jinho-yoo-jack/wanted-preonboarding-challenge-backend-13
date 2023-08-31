package com.wanted.preonboarding.cafe.controller.reponse;

import com.wanted.preonboarding.cafe.service.handler.dto.CafeOrderItemResultDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CafeOrderItemResponse {
    private String menuName;
    private int quantity;

    public static CafeOrderItemResponse of(CafeOrderItemResultDto dto) {
        return new CafeOrderItemResponse(dto.getMenuName(), dto.getQuantity());
    }
}
