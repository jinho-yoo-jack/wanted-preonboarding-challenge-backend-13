package com.wanted.preonboarding.cafe.DTO;

import lombok.Getter;

@Getter
public class CreateItemRequest {
    String name;
    Integer amount;
    Integer price;
}
