package com.wanted.preonboarding.cafe.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@Getter @Setter
@NoArgsConstructor
public class OrderDto {
    Map<String, Integer> orders;
    long customerBalance;
}
