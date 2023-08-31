package com.wanted.preonboarding.cafe.service.handler;

/**
 * description    : 결제 관련 모듈
 * packageName    : com.wanted.preonboarding.cafe.service.handler
 * fileName       : IntelliJ IDEA
 * author         : ggong
 * date           : 2023/08/31
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023/08/31        ggong       최초 생성
 */
public interface Pay {
	/**
	 * 결제와 결제 성공 여부를 리턴하는 메서드
	 * @return
	 */
	boolean pay(long price);
}
