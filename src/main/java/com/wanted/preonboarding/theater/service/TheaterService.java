package com.wanted.preonboarding.theater.service;

import com.wanted.preonboarding.theater.dto.RequestMessage;
import com.wanted.preonboarding.theater.service.handler.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TheaterService {
	private final Theater theater = new Theater();

	public String enter(RequestMessage requestMessage) {
		
		Audience audience = createAudience(requestMessage);
		theater.enter(audience);
		
		//남은 돈 출력
        System.out.println("Remaining money in bags: " + audience.getBag().getAmount());
		
		return "Have a good time.";
	}

	private Audience createAudience(RequestMessage requestMessage) {
		
		System.out.println(requestMessage.getAmount());
		Bag bag = new Bag(requestMessage.getAmount());
		if (requestMessage.getIsInvitation()) {
			bag.setInvitation(new Invitation());
		}

		return new Audience(bag);
	}

}
