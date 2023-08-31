package com.wanted.preonboarding.cafe;

import lombok.Getter;

/**
 * description    : 카페 메뉴
 * packageName    : com.wanted.preonboarding.cafe.service.handler
 * fileName       : IntelliJ IDEA
 * author         : ggong
 * date           : 2023/08/27
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023/08/27        ggong       최초 생성
 */
public enum MENU {
	AMERICANO(1500),
	LATTE(2500),
	TEA(2000);

	@Getter private int price;

	private MENU(int price) {
		this.price = price;
	}
}
