package com.wanted.preonboarding.cafe.service.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * description    : 카드 결제 관련
 * packageName    : com.wanted.preonboarding.cafe.service.handler
 * fileName       : IntelliJ IDEA
 * author         : ggong
 * date           : 2023/08/31
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023/08/31        ggong       최초 생성
 */
@Component
@Slf4j
public class PayCard implements Pay {

	@Override
	public boolean pay(long price) {
		log.info("카드결제 성공");
		return true;
	}
}
