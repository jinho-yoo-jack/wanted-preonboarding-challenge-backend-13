package com.wanted.preonboarding.cafe.service.handler;

public class CoffeeMakerFactory {
    public static CoffeeMaker create(Barista.Rank rank, Barista.Status status) {
        if (status == Barista.Status.MAKING) throw new IllegalStateException("바리스타가 커피를 만드는 중입니다. 다시 시도하세요.");
        if (rank == Barista.Rank.BEGINNER)
            return new BasicCoffeeMaker();
        throw new IllegalArgumentException(String.format("%s 랭킹의 바리스타는 존재하지 않습니다", rank.toString()));
    }
}
