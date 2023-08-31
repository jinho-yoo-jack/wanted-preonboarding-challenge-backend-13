package com.wanted.preonboarding.cafe.service;

import com.wanted.preonboarding.cafe.dto.request.RequestMenu;

public interface CafeService {
    String orderFrom(RequestMenu requestMenu);

    Long getMenuPrice(String name);
}
