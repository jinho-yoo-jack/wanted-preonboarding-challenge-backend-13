package com.wanted.preonboarding.cafe.service.handler;

import com.wanted.preonboarding.cafe.dto.CafeRequest;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class Order {
  private Menu menu;
  private long quantity;

  public static Order create(CafeRequest.Order request) {
    return new Order(request.getMenu(), request.getQuantity());
  }

  public long getPrice() {
    return this.menu.getPrice() * this.quantity;
  }

}
