package com.wanted.preonboarding.cafe.service.handler;

import java.util.Optional;

public interface Payment extends DiscountPolicy {
     void pay(Long price);

}
