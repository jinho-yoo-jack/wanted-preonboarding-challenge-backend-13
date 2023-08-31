package com.wanted.preonboarding.theater.service.dto;

import com.wanted.preonboarding.theater.service.handler.Invitation;
import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class AudienceTicketPurchaseDto {
    @Nonnull private long amount;
    @Nullable private Invitation invitation;
}
