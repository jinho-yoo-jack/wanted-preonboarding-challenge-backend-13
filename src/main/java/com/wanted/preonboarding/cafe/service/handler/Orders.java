package com.wanted.preonboarding.cafe.service.handler;

import lombok.*;

import java.util.Map;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Orders {
    private String paymentMethod;
    private Map<String, Integer> menuMap;
}
