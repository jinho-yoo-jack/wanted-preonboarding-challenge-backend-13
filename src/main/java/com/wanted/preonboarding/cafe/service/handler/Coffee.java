package com.wanted.preonboarding.cafe.service.handler;

public class Coffee {
  private int coffeeId; // 커피 아이디
  private String coffeeName; // 커피 이름
  private int amount; // 커피 가격
  private int coffeeCnt; // 커피 주문 개수

  public Coffee(int coffeeId, int amount, String coffeeName) {
    this.coffeeId = coffeeId;
    this.coffeeName = coffeeName;
  }
  public Coffee(int coffeeId, String coffeeName, int coffeeCnt) {
    this.coffeeId = coffeeId;
    this.coffeeName = coffeeName;
    this.coffeeCnt = coffeeCnt;
  }

  public int getCoffeeId() {
    return coffeeId;
  }

  public void setCoffeeId(int coffeeId) {
    this.coffeeId = coffeeId;
  }

  public String getCoffeeName() {
    return coffeeName;
  }

  public void setCoffeeName(String coffeeName) {
    this.coffeeName = coffeeName;
  }
}
