package com.cassio.polychat.adapter.outbound.persistence.repository;

import com.cassio.polychat.adapter.outbound.persistence.entity.UserEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

import java.util.UUID;

    public interface UserR2dbcRepository extends ReactiveCrudRepository<UserEntity, UUID> {

        Mono<Boolean> existsByUsername(String username);

    }
