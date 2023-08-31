package com.wanted.preonboarding.domain.cafe.dto.request;

import java.util.HashMap;

public record MyOrdersDto(
    HashMap<String, Integer> myOrders
) {

  public HashMap<String, Integer> toMyOrders() {
    return myOrders;
  }

}
