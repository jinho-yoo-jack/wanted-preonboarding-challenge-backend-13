package com.wanted.preonboarding.cafe.service.handler;

import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class OfficialMenuStatics implements MenuStatics {
    @Override
    public Map<String, Long> getMenu() {
        return Map.of("아메리카노", 3000L, "카페라떼", 4000L, "카푸치노", 4500L);
    }
}
