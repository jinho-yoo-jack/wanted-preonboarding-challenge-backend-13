package com.wanted.preonboarding.theater.service.handler;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class SampleDatas {
  // TICKET 목록 상수
  public static final List<Ticket> TICKET_LIST = new ArrayList<Ticket>();
  public static final Long SELLER_AMOUNT = 2000L;
  public static final List<Audience> AUDIENCE_LIST = new ArrayList<Audience>();
  public static final List<Bag> BAG_LIST = new ArrayList<Bag>();
  public static final List<Invitation> INVITATION_LIST = new ArrayList<Invitation>();

  static {
    TICKET_LIST.add(new Ticket(1, "티켓A", 100L));
    TICKET_LIST.add(new Ticket(2, "티켓B", 200L));
    TICKET_LIST.add(new Ticket(3, "티켓C", 150L));
    TICKET_LIST.add(new Ticket(4, "티켓D", 250L));
    TICKET_LIST.add(new Ticket(5, "티켓E", 300L)); 

    INVITATION_LIST.add(new Invitation(1, LocalDateTime.of(2023, Month.SEPTEMBER, 3, 15, 30)));
    INVITATION_LIST.add(new Invitation(2, null));
    INVITATION_LIST.add(new Invitation(3, LocalDateTime.of(2023, Month.SEPTEMBER, 3, 15, 30)));
    INVITATION_LIST.add(new Invitation(4, LocalDateTime.of(2023, Month.SEPTEMBER, 3, 15, 30)));
    INVITATION_LIST.add(new Invitation(5, LocalDateTime.of(2023, Month.SEPTEMBER, 3, 15, 30)));

    BAG_LIST.add(new Bag(1, 1000L, INVITATION_LIST.get(0), null));
    BAG_LIST.add(new Bag(2, 2000L, INVITATION_LIST.get(1), null));
    BAG_LIST.add(new Bag(3, 3000L, INVITATION_LIST.get(2), null));
    BAG_LIST.add(new Bag(4, 4000L, INVITATION_LIST.get(3), null));
    BAG_LIST.add(new Bag(5, 5000L, INVITATION_LIST.get(4), null));

    AUDIENCE_LIST.add(new Audience(1, BAG_LIST.get(0)));
    AUDIENCE_LIST.add(new Audience(2, BAG_LIST.get(1)));
    AUDIENCE_LIST.add(new Audience(3, BAG_LIST.get(2)));
    AUDIENCE_LIST.add(new Audience(4, BAG_LIST.get(3)));
    AUDIENCE_LIST.add(new Audience(5, BAG_LIST.get(4)));
  }
}
