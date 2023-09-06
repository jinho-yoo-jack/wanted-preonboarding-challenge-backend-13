package com.wanted.preonboarding.cafe.dto;

import lombok.Getter;

public class OrderRequest {
    @Getter
    public static class OrderRequestDto {
        private String typeOfBeverage;
        private Integer amount;
        private String paymentMethod;
    }
}
