package com.wanted.preonboarding.cafe.service.handler;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CafeOrder {
    private List<CafeOrderItem> items;
    private long totalPrice;
}
