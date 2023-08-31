package com.wanted.preonboarding.cafe.DTO;


import lombok.Getter;

import java.util.List;

@Getter
public class OrderRequest {
    String paymentMethod;
    List<ItemDto> items;
}
