package com.wanted.preonboarding.cafe.controller.request;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CafeOrderItemRequest {
    private String menuName;
    private int quantity;
}
