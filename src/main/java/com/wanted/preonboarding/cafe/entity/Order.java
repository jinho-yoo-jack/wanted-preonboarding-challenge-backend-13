package com.wanted.preonboarding.cafe.entity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
public class Order {
    Coffee coffee;
    long quantity;
}
