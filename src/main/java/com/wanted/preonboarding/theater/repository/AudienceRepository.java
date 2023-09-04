package com.wanted.preonboarding.theater.repository;

import com.wanted.preonboarding.theater.service.handler.Audience;
import com.wanted.preonboarding.theater.service.handler.Bag;
import com.wanted.preonboarding.theater.service.handler.Invitation;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class AudienceRepository {

    private final Map<Long, Audience> repository = new ConcurrentHashMap<>();

    @PostConstruct
    public void initialize() {
        repository.put(1L, new Audience(new Bag(1000L)));
        repository.put(2L, new Audience(new Bag(new Invitation(), 1000L)));
    }

    public Audience findById(Long id) {
        repository.putIfAbsent(id, new Audience(new Bag(1000L)));
        return repository.get(id);
    }

}
