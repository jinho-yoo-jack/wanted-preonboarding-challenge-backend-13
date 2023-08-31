package com.wanted.preonboarding.theater.service.handler;

import java.util.Objects;
public class Money {
    private final Long money;
    public Money( Long money){
        verifyMoney(money);
        this.money = money;
    }

    private void verifyMoney(Long money) {
        if (money < 0) {
            throw new IllegalArgumentException("Money cannot be negative.");
        }
    }

    public Money plus(Money amount){
        return new Money(this.money + amount.money);
    }

    public Money minus(Money amount){
        return new Money(this.money - amount.money);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Money money1)) return false;
        return Objects.equals(money, money1.money);
    }

    @Override
    public int hashCode() {
        return Objects.hash(money);
    }

    @Override
    public String toString() {
        return "Money{" +
                "money=" + money +
                '}';
    }
}
