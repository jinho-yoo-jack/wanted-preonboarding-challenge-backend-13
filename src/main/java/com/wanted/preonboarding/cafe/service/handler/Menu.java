package com.wanted.preonboarding.cafe.service.handler;

import lombok.Getter;

@Getter
public enum Menu {
  AMERICANO(100),
  LATTE(200),
  ADE(300);

  private final long price;

  Menu(long price) {
    this.price = price;
  }


}
