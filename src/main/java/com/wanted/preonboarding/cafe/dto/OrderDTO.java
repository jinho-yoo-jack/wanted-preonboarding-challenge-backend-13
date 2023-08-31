package com.wanted.preonboarding.cafe.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.wanted.preonboarding.cafe.service.handler.Menu;
import com.wanted.preonboarding.cafe.service.handler.Order;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class OrderDTO {

	private List<OrderMenuDTO> menus;
	private String requirements;

	public Order toOrder() {
		List<Order.OrderMenu> orderMenus = menus.stream()
			.map(OrderMenuDTO::toOrderMenu)
			.collect(Collectors.toList());

		return new Order(
			orderMenus,
			requirements
		);
	}

	@Getter
	@ToString
	private static class OrderMenuDTO {
		private Menu menu;
		private int quantity;

		public Order.OrderMenu toOrderMenu() {
			return new Order.OrderMenu(menu, quantity);
		}
	}
}
