package com.wanted.preonboarding.theater.service.handler;

public class Bag {
    private int audienceId; // 가방 주인 아이디
    private Long amount; // 돈의 양
    private final Invitation invitation; // 초대 정보 객체
    private Ticket ticket; // 관람 티켓

    public Bag(int audienceId, long amount, Invitation invitation, Ticket ticket) {
        this.audienceId = audienceId;
        this.amount = amount;
        this.invitation = invitation;
        this.ticket = ticket;
    }

    public Bag(int id, long amount) {
        this(null, amount);
    }

    /**
     * 기본 생성자 (파라미터)
     * 
     * @param amount 돈의 양
     */
    public Bag(long amount) {
        this(null, amount);
    }

    /**
     * 기본 생성자 (파라미터))
     * 
     * @param invitation 초대여부
     * @param amount     돈의 양
     */
    public Bag(Invitation invitation, long amount) {
        this.invitation = invitation;
        this.amount = amount;
    }

    /**
     * 초대 정보 객체
     * 
     * @return 초대 여부
     */
    public boolean hasInvitation() {
        return invitation.getInvitationDate() != null;
    }

    /**
     * 티켓 존재 여부
     * 
     * @return 티켓 존재 여부
     */
    public boolean hasTicket() {
        return ticket != null;
    }

    /**
     * 티켓 setter
     * 
     * @param ticket
     */
    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    /**
     * 티켓 구매 후 차감
     * 
     * @param amount
     */
    public void minusAmount(long amount) {
        this.amount -= amount;
    }

    /**
     * 티켓 환불
     * 
     * @param amount
     */
    public void plusAmount(long amount) {
        this.amount += amount;
    }
}
