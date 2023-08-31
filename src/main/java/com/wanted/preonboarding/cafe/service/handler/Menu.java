package com.wanted.preonboarding.cafe.service.handler;

import lombok.Getter;

@Getter
public enum Menu {

	AMERICANO(100L),
	CAFFE_MOCHA(200L),
	VANILLA_LATTE(200L),
	;

	private final long price;

	Menu(long price) {
		this.price = price;
	}
}
