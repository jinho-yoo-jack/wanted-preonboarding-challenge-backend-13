package com.wanted.preonboarding.theater.service.handler;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Invitation {
	private LocalDateTime when;

	public Invitation(LocalDateTime when) {
		this.when = when;
	}

	public Invitation() {
		
	}

	public void setWhen(LocalDateTime when) {
		this.when = when;
	}

	public LocalDateTime getWhen() {
		return when;
	}
}
