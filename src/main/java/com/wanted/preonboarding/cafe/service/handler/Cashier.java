package com.wanted.preonboarding.cafe.service.handler;

import java.util.Map;

public class Cashier {
	private final Cafe cafe;

	public Cashier(Cafe cafe) {
		this.cafe = cafe;
	}

	public long calculateTotalPrice(Map<String, Integer> orders) {
		long totalPrice = 0L;
		Map<String, Long> drinkPrices = cafe.getDrinkFee();

		for (String key : orders.keySet()) {

			if (drinkPrices.containsKey(key)) {
				totalPrice += drinkPrices.get(key) * orders.get(key);
			} else {
				totalPrice = 0;
			}
		}
		return totalPrice;
	}

	public String takeOrder(Map<String, Integer> receivedOrders, long totalPrice) {
		if (totalPrice == 0) {
			return "없는 메뉴입니다! 다시 선택해주세요!";
		} else {
			cafe.plusSales(totalPrice);
			return sendTo(new Barista(0, 0), receivedOrders);
		}
	}

	private String sendTo(Barista barista, Map<String, Integer> receivedOrders) {

		return barista.makeCoffeeTo(receivedOrders);
	}

}
