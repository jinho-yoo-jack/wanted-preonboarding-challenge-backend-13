package com.wanted.preonboarding.cafe.service.handler;

import com.wanted.preonboarding.cafe.MENU;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


/**
 * description    : 주문
 * packageName    : com.wanted.preonboarding.cafe.service.handler
 * fileName       : IntelliJ IDEA
 * author         : ggong
 * date           : 2023/08/29
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023/08/29        ggong       최초 생성
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Order {
	/** 주문 메뉴 */
	private MENU menu;

	/** 주문 수량 */
	private int count;
}
