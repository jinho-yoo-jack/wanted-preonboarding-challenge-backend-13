package com.wanted.preonboarding.domain.cafe.application;

import com.wanted.preonboarding.domain.cafe.entity.Cafe;
import com.wanted.preonboarding.domain.cafe.entity.Cashier;
import com.wanted.preonboarding.domain.cafe.entity.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CafeService {

  private final Cafe wantedCafe;

  public String orderFrom(HashMap<String, Integer> menu, HashMap<String, Long> coffeePrices,
      HashMap<String, Integer> myOrders) {
    Cashier cashier = new Cashier(wantedCafe, menu, coffeePrices);
    Customer c1 = new Customer("Card", myOrders);
    return c1.buyCoffee(cashier);
  }
}
