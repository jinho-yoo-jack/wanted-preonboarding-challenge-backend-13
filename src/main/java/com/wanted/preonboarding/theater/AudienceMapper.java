package com.wanted.preonboarding.theater;

import com.wanted.preonboarding.theater.service.handler.Audience;
import com.wanted.preonboarding.theater.service.handler.AudienceDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AudienceMapper {

    AudienceDto toDto(Audience audience);

    Audience toEntity(AudienceDto audienceDto);
}
