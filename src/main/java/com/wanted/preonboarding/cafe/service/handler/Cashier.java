package com.wanted.preonboarding.cafe.service.handler;

import lombok.*;

import java.util.Map;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Cashier {
    private Cafe cafe;
}
