package com.wanted.preonboarding.theater.service.handler;

import com.wanted.preonboarding.theater.service.Interface.Pass;

public class Audience {
    private Long money;
    private Pass pass;

    public Audience() {
        this(null, 0L);
    }

    public Audience(Long money) {
        this(null, money);
    }

    public Audience(Pass pass) {
        this(pass, 0L);
    }

    public Audience(Pass pass, Long money){
        this.pass = pass;
        this.money = money;
    }

    public boolean hasInvitation() {
        return ( this.pass != null &&
            this.pass.getClass().getName().equals("Invitation")
                );
    }
    public boolean hasTicket() {

        return (this.pass != null &&
            this.pass.getClass().getName().equals("Ticket")
        );
    }
    public void setPass(Pass pass) {
        this.pass = pass;
    }
    public Pass getPass() { return this.pass; }

    public Long getMoney() {
        return this.money;
    }
    public boolean minusMoney(long money) {
        if(money > this.money) {
            return false;
        }
        this.money -= money;
        return true;
    }
    public void plusMoney(long money) {
        this.money += money;
    }
}