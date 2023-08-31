package com.wanted.preonboarding.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TheaterRequestDto {
    @Getter
    private long amount;
    private boolean invitation;

    public boolean hasInvitation() {
        return invitation;
    }
}
