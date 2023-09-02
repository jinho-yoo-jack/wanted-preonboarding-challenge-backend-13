package com.wanted.preonboarding.cafe.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum BaristaEnum {
    BEGINNER_WAIT(0, 0),
    MIDDLE_WAIT(1, 0),
    MASTER_WAIT(2, 0);

    private int rank;
    private int status;
}
