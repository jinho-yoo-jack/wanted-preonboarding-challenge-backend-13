package com.wanted.preonboarding.cafe.dto;

import com.wanted.preonboarding.cafe.service.handler.Menu;
import lombok.Data;

public class CafeRequest {

  @Data
  public static class Order {
    private Menu menu;
    private Integer count;
  }
}
