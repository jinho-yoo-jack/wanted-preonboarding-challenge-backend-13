package com.wanted.preonboarding.cafe.controller;

import lombok.Data;

import java.util.List;

@Data
public class OrderDto {
    private String paymentType;
    private List<Order> orders;
}
