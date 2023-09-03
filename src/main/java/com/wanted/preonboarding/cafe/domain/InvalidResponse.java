package com.wanted.preonboarding.cafe.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class InvalidResponse {
    private String field;

    private String message;

    private Object rejectValue;
}
