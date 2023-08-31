package com.wanted.preonboarding.theater.dto;

public class RequestMessage {

	private Long amount = 0L; // 관람객의 보유 금액
	private Boolean isInvitation = false; // 초대장 보유 여부

	public RequestMessage() {

	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public Boolean getIsInvitation() {
		return isInvitation;
	}

	public void setIsInvitation(Boolean isInvitation) {
		this.isInvitation = isInvitation;
	}

}
