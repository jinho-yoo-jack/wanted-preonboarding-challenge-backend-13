package com.wanted.preonboarding.cafe.dto;

import com.wanted.preonboarding.cafe.domain.Order;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class OrderRequest {
    private String paymentType;
    private List<Order> order;
}
