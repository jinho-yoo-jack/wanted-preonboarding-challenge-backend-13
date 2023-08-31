package com.wanted.preonboarding.cafe.controller.response;

import com.wanted.preonboarding.cafe.service.handler.dto.CafeOrderResultDto;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CafeOrderResponse {
    private List<CafeOrderItemResponse> items;
    private long totalPrice;

    public static CafeOrderResponse of(CafeOrderResultDto dto) {
        List<CafeOrderItemResponse> items = dto.getItems()
                .stream()
                .map(CafeOrderItemResponse::of)
                .toList();
        return new CafeOrderResponse(items, dto.getTotalPrice());
    }
}
