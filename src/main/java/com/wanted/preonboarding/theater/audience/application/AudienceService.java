package com.wanted.preonboarding.theater.audience.application;

import com.wanted.preonboarding.theater.audience.domain.Audience;
import com.wanted.preonboarding.theater.audience.domain.AudienceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AudienceService {

    private final static String AUDIENCE_NOT_FOUND = "관객을 찾을 수 없습니다.";
    private final AudienceRepository audienceRepository;

    @Transactional
    public void add(Audience audience) {
        audienceRepository.save(audience);
    }

    public Audience findById(long id) {
        return audienceRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(AUDIENCE_NOT_FOUND));
    }

    public List<Audience> findAll() {
        return audienceRepository.findAll();
    }
}
