package com.wanted.preonboarding.cafe.service.handler;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;


import java.util.List;

/**
 * description    : 주문 요청
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
public class OrderRequest {
	/** 주문 목록 */
	@NotEmpty
	private final List<Order> orderList;

	/** 결제 수단 */
	@NotEmpty
	private final String paymentMethod;

	@NotEmpty
	private final int baristaRank;

	public OrderRequest(List<Order> orderList, String paymentMethod, int baristaRank) {
		this.orderList = orderList;
		this.paymentMethod = paymentMethod;
		this.baristaRank = baristaRank;
	}
}
