package com.wanted.preonboarding.cafe.dto;

import com.wanted.preonboarding.cafe.domain.Order;
import com.wanted.preonboarding.cafe.domain.PaymentType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

import static com.wanted.preonboarding.cafe.domain.ValidateMessage.INVALID_ORDER_SIZE;
import static com.wanted.preonboarding.cafe.domain.ValidateMessage.INVALID_PAYMENT_TYPE;

@Getter
@AllArgsConstructor
public class OrderRequest {
    @NotNull(message = INVALID_PAYMENT_TYPE)
    private PaymentType paymentType;

    @Size(min = 1, message = INVALID_ORDER_SIZE)
    private List<Order> order;
}
