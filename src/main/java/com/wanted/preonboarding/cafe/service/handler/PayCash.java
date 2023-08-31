package com.wanted.preonboarding.cafe.service.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * description    :
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
public class PayCash  implements Pay {

	public boolean pay(long price) {
		log.info("현금결제 성공");
		return true;
	}
}
