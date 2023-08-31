package com.wanted.preonboarding.domain.cafe.entity;

import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
@Getter
public class Cafe {

  private final String name;
  private Long sales;

  public Cafe() {
    this.name = "wantedCodingCafe";
    this.sales = 0L;
  }

  public String getCafeName() {
    return name;
  }

  public void plusSales(Long amount) {
    this.sales += amount;
  }

  public void minusSales(Long amount) {
    this.sales -= amount;
  }
}
