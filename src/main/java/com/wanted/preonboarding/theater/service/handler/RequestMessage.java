package com.wanted.preonboarding.theater.service.handler;

public class RequestMessage {
	private Invitation invitation;
    private Long amount;
    public RequestMessage(Long amount) {
    	this.invitation =null;
    	this.amount = amount;
    }

    public RequestMessage(Invitation invitation, Long amount) {
        this.invitation = invitation;
        this.amount = amount;
    }

    public Invitation getInvitation() {
        return invitation;
    }

    public Long getAmount() {
        return amount;
    }
}
