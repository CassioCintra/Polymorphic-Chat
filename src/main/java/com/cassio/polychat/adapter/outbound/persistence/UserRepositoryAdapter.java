package com.cassio.polychat.adapter.outbound.persistence;

import com.cassio.polychat.adapter.outbound.persistence.entity.UserEntity;
import com.cassio.polychat.adapter.outbound.persistence.repository.UserR2dbcRepository;
import com.cassio.polychat.domain.model.User;
import com.cassio.polychat.domain.port.outbound.UserRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
@RequiredArgsConstructor
public class UserRepositoryAdapter implements UserRepositoryPort {

    private final UserR2dbcRepository repository;

    @Override
    public Mono<Boolean> existsByUsername(String username) {
        return repository.existsByUsername(username);
    }

    @Override
    public Mono<User> save(User user) {
        UserEntity entity = UserEntity.builder()
                .id(user.getId())
                .username(user.getUsername())
                .password(user.getPassword())
                .createdAt(user.getCreatedAt())
                .build();

        return repository.save(entity)
                .map(saved -> User.builder()
                        .id(saved.getId())
                        .username(saved.getUsername())
                        .password(saved.getPassword())
                        .createdAt(saved.getCreatedAt())
                        .build()
                );
    }
}
