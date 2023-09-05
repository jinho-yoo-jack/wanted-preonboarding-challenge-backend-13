package com.wanted.preonboarding.theater.audience.domain;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class AudienceRepository {

    private final ConcurrentHashMap<Long, Audience> audiences = new ConcurrentHashMap<>();
    private volatile long idSequence = 0L;

    public synchronized void save(Audience audience) {
        if (audience.getId() < 1) {
            idSequence++;
            audience.setId(idSequence);

        }
        audiences.put(idSequence, audience);
    }

    public Optional<Audience> findById(long id) {
        return Optional.of(audiences.get(id));
    }

    public List<Audience> findAll() {
        return audiences.values().stream().toList();
    }
}
