package com.wanted.preonboarding.theater.dto;

import com.wanted.preonboarding.theater.entity.Audience;
import com.wanted.preonboarding.theater.entity.Bag;
import com.wanted.preonboarding.theater.entity.Invitation;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.lang.Nullable;

import java.time.LocalDateTime;

@Getter
@Setter
public class AudienceInputDTO {
    @NonNull
    private Long amount;
    @Nullable
    private LocalDateTime when;

    public Audience enterInfoDTOToAudience(){
        // 티켓이 없는 Audience 인 경우
        if(this.getWhen() == null){
            return new Audience(new Bag(this.getAmount()));
        }
        return new Audience(new Bag(new Invitation(this.getWhen()), this.getAmount()));
    }
}
