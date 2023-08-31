package com.wanted.preonboarding.cafe.dto.request;

import com.wanted.preonboarding.cafe.service.handler.customer.Order;
import com.wanted.preonboarding.cafe.service.handler.customer.PaymentMethodType;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class OrderCustomerRequest {

    private final PaymentMethodType paymentMethodType;

    private final List<Order> orders;

    @Builder
    public OrderCustomerRequest(PaymentMethodType paymentMethodType, List<Order> orders) {
        this.paymentMethodType = paymentMethodType;
        this.orders = orders;
    }


}
