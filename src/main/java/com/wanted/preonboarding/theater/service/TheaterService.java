package com.wanted.preonboarding.theater.service;

import com.wanted.preonboarding.theater.service.handler.Audience;
import com.wanted.preonboarding.theater.service.handler.Theater;
import com.wanted.preonboarding.theater.service.handler.Ticket;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TheaterService {
	private final Theater theater;
	private final String SUCCESS_ENTER = "입장 허용";
	private final String FAIL_ENTER = "입장 불가";


	/**
	 * 티켓이 있는지 확인한 후 입장 시킨다
	 *
	 * @param audience 관객
	 * @return
	 */
	public String enter(Audience audience) {
		String result = "";

		if (audience.hasInvitation()) {//초대권이 있다면
			Ticket ticket = theater.checkInvitation(audience.getInvitation());
            if (ticket != null) {
                audience.setTicket(ticket);// 티켓으로 교환해줌
                result += "초대권 확인.";
            } else {
                result += "초대권 날짜 다름.";
            }
		}

		if (audience.getAmount() >= theater.getTicketFee()) { // 돈이 충분하다면
			Ticket ticket = theater.sellTicket(audience.minusAmount(theater.getTicketFee()));//티켓을 구매함
			audience.setTicket(ticket);
			result += "티켓 구매 확인.";
		}

		if (theater.enter(audience)) {
			result += SUCCESS_ENTER;
		} else {
			result += FAIL_ENTER;
		}

		return result;
	}
}
