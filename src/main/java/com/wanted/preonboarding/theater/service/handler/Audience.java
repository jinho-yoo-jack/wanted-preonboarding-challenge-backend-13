package com.wanted.preonboarding.theater.service.handler;

public class Audience {
    private final Wallet wallet;

    public Audience(Wallet wallet){
        this.wallet = wallet;
    }

    public Wallet getWallet(){ return wallet;}
}