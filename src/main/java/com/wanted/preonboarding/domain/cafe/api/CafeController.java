package com.wanted.preonboarding.domain.cafe.api;

import com.wanted.preonboarding.domain.cafe.application.CafeService;
import com.wanted.preonboarding.domain.cafe.dto.request.MyOrdersDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/cafe")
@RequiredArgsConstructor
public class CafeController {

  private final CafeService cafeService;

  @GetMapping("hello")
  public String welcomeMessage() {
    return "Welcome to The Wanted coding cafe!!";
  }

  @GetMapping("order")
  public String orderFromMenu(@RequestBody MyOrdersDto reqDto) {
    HashMap<String, Integer> menu = new HashMap<String, Integer>();
    menu.put("LATTE", 1);
    menu.put("ADE", 2);
    menu.put("AMERICANO", 3);

    HashMap<String, Long> coffeePrices = new HashMap<>();
    coffeePrices.put("LATTE", 1500L);
    coffeePrices.put("ADE", 2000L);
    coffeePrices.put("AMERICANO", 1000L);
    return cafeService.orderFrom(menu, coffeePrices, reqDto.toMyOrders());
  }
}
