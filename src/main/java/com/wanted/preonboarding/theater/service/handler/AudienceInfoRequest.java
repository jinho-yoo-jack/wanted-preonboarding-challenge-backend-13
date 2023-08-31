package com.wanted.preonboarding.theater.service.handler;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * description    : 관객 정보
 * packageName    : com.wanted.preonboarding.theater.service.handler
 * fileName       : IntelliJ IDEA
 * author         : ggong
 * date           : 2023/08/26
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023/08/26        ggong       최초 생성
 */

@Getter  @Setter
@NoArgsConstructor
@AllArgsConstructor
public class AudienceInfoRequest {
	/** 티켓 유무*/
	private boolean ticket;

	public void setTicket(String ticket) {
		this.ticket = Boolean.parseBoolean(ticket);
	}
	public void setTicket(boolean ticket) {
		this.ticket = ticket;
	}

	/** 가진 돈 */
	@PositiveOrZero(message = "양수만 입력 가능합니다.")
	private long amount;

	public void setAmount(int amount) {
		this.amount = Long.valueOf(amount);
	}
	public void setAmount(Long amount) {
		this.amount = amount;
	}

	/** 초대권 날짜 */
	@Pattern(regexp = "[0-9]{4}\\-[0-9]{2}\\-[0-9]{2} [0-9]{2}", message = "[2023-12-12 20]형식으로 입력 바랍니다.")
	private String locationDateTime;

	public Audience toAudience() {
		Invitation invitation = null;
		if (this.locationDateTime != null && !"".equals(this.locationDateTime)) {
			invitation = new Invitation(this.locationDateTime);
		}

		Ticket ticket = null;
		if (this.ticket) {
			ticket = new Ticket((-1L));
		}

		return new Audience(new Bag(invitation, this.amount,ticket));
	}
}
