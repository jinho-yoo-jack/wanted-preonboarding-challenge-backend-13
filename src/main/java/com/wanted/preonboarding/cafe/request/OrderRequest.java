package com.wanted.preonboarding.cafe.request;

import com.wanted.preonboarding.cafe.service.handler.Customer;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Map;

@Getter
@Setter
@ToString
public class OrderRequest {
    private Map<String, Long> orderMenus;

    public Customer toCustomer(final OrderRequest orderRequest) {
        return Customer.builder()
                .myOrders(orderRequest.orderMenus).build();
    }
}
