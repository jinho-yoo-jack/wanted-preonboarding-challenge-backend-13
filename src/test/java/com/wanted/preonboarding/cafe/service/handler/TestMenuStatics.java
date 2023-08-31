package com.wanted.preonboarding.cafe.service.handler;

import java.util.HashMap;
import java.util.Map;

public class TestMenuStatics implements MenuStatics {
    private Map<String, Long> menu = new HashMap<>();
    @Override
    public Map<String, Long> getMenu() {
        menu.put("아메리카노", 3000L);
        menu.put("카페라떼", 4000L);
        return menu;
    }
}
