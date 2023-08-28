package com.wanted.preonboarding.cafe.service.handler;

import java.util.HashMap;
import java.util.Map;

public class Cashier {
	//데이터 베이스를 써야하는 부분을 임의로 연결 (동시성문제 있을 수 있음)
	private Map<String, Long> beverageList= new HashMap<>();
	
	//세가지 정도 음료로 초기화
	public Cashier () {
		beverageList.put("Americano", 2000L);
		beverageList.put("Latte", 2500L);
		beverageList.put("ColdBrew", 4000L);
	}
	
	// 총 금액 계산
    public long calculateTotalPrice(Map<String, Integer> orders) {
        long totalPrice = 0L;
        for (String key : orders.keySet()) {
        	totalPrice += beverageList.get(key) * orders.get(key);
        }
        return totalPrice;
    }
}
