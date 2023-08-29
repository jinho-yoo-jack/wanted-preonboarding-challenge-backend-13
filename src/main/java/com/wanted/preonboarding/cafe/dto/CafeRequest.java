package com.wanted.preonboarding.cafe.dto;

import com.wanted.preonboarding.cafe.service.handler.Order;
import lombok.Getter;

import java.util.List;

@Getter
public class CafeRequest {
    private List<Order> orders;
}
