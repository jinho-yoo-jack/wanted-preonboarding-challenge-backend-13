package com.wanted.preonboarding.cafe.service.dto;

import lombok.Data;

import java.util.Map;

@Data
public class CustomerDto {
    final String paymentMethod;
    final Map<String,Integer> order;
}
