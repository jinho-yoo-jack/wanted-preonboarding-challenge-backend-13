package com.wanted.preonboarding.domain.theater.dto.request;

import com.wanted.preonboarding.domain.theater.entity.Audience;
import com.wanted.preonboarding.domain.theater.entity.Bag;
import com.wanted.preonboarding.domain.theater.entity.Invitation;
import com.wanted.preonboarding.domain.theater.entity.Ticket;
import com.wanted.preonboarding.domain.theater.entity.TicketOffice;
import com.wanted.preonboarding.domain.theater.entity.TicketSeller;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import java.time.LocalDateTime;
import lombok.Builder;

@Builder
public record TheaterEnterDto(
    @NotNull(message = NULL_MESSAGE) @PositiveOrZero(message = BAG_FEE_INVALID)
    Long bagFee,
    @NotNull(message = NULL_MESSAGE) @PositiveOrZero(message = TICKET_OFFICE_AMOUNT_INVALID)
    Long ticketOfficeAmount,
    @NotNull(message = NULL_MESSAGE) @PositiveOrZero(message = TICKET_FEE_INVALID)
    Long ticketFee,
    String invitationDate,
    Boolean haveTicket
) {

  private static final String NULL_MESSAGE = "입력되지 않은 값이 있습니다.";
  private static final String BAG_FEE_INVALID = "가방은 0원 미만의 값을 가질 수 없습니다.";
  private static final String TICKET_OFFICE_AMOUNT_INVALID = "티켓 판매소는 0원 미만의 값을 가질 수 없습니다.";
  private static final String TICKET_FEE_INVALID = "티켓의 가격은 0원 미만의 값을 가질 수 없습니다.";

  public Audience toAudience() {
    if (invitationDate == null) {
      if (haveTicket == null) {
        return new Audience(new Bag(bagFee));
      }
      return new Audience(new Bag(bagFee, new Ticket(ticketFee)));
    }
    LocalDateTime time = LocalDateTime.parse(invitationDate);
    if (haveTicket == null) {
      return new Audience(new Bag(new Invitation(time), bagFee));
    }
    return new Audience(new Bag(new Invitation(time), bagFee, new Ticket(ticketFee)));
  }

  public TicketSeller toTicketSeller() {
    return new TicketSeller(new TicketOffice(ticketOfficeAmount, new Ticket(ticketFee)));
  }
}
