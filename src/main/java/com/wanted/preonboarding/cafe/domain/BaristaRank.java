package com.wanted.preonboarding.cafe.domain;

public enum BaristaRank {
    BEGINNER(0),
    MIDDLE(1),
    MASTER(2);
    private int rank;

    BaristaRank(int rank) {
        this.rank = rank;
    }

}
