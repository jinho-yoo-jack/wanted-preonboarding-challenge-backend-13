package com.wanted.preonboarding.cafe.service.handler;

import java.util.List;

import lombok.Getter;

@Getter
public class Order {

	private List<OrderMenu> orderMenus;
	private String requirements;

	public Order(List<OrderMenu> orderMenus, String requirements) {
		this.orderMenus = orderMenus;
		this.requirements = requirements;
	}

	public long getTotalPrice() {
		long totalPrice = 0;
		for (OrderMenu orderMenu : orderMenus) {
			totalPrice += orderMenu.getTotalPrice();
		}

		return totalPrice;
	}

	@Getter
	public static class OrderMenu {
		private Menu menu;
		private int quantity;

		public OrderMenu(Menu menu, int quantity) {
			this.menu = menu;
			this.quantity = quantity;
		}

		public long getEachPrice() {
			return menu.getPrice();
		}

		public long getTotalPrice() {
			return getEachPrice() * quantity;
		}
	}
}
