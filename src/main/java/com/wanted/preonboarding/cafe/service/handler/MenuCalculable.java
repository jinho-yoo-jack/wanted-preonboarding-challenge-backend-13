package com.wanted.preonboarding.cafe.service.handler;

import java.util.Map;

public interface MenuCalculable {
    long calculate(Map<MenuItem, Integer> orders);
}
