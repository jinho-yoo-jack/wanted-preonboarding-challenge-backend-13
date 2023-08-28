package com.wanted.preonboarding.cafe.entity.dto;

import com.wanted.preonboarding.cafe.entity.Menu;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class OrderRequestParam {
   private Menu menu;
   private Integer quantity;
}
