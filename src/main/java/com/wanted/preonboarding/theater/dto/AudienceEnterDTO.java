package com.wanted.preonboarding.theater.dto;

import java.time.LocalDateTime;

import com.wanted.preonboarding.theater.service.handler.Audience;
import com.wanted.preonboarding.theater.service.handler.Bag;
import com.wanted.preonboarding.theater.service.handler.Invitation;
import com.wanted.preonboarding.theater.service.handler.Ticket;

import lombok.Getter;

@Getter
public class AudienceEnterDTO {

	private Long amount;
	private InvitationDTO invitation;
	private TicketDTO ticket;

	public Audience toAudience() {
		Invitation invitation = this.invitation == null ? null : Invitation.builder()
			.when(this.invitation.getWhen())
			.build();

		Ticket ticket = this.ticket == null ? null : Ticket.builder()
			.fee(this.ticket.getFee())
			.build();

		Bag bag = Bag.builder()
			.amount(amount == null ? 0L : amount)
			.invitation(invitation)
			.ticket(ticket)
			.build();

		return Audience.builder()
			.bag(bag)
			.build();
	}

	@Getter
	private static class InvitationDTO {
		private LocalDateTime when;
	}

	@Getter
	private static class TicketDTO {
		private Long fee;
	}
}
