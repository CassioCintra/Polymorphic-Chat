package com.cassio.polychat.domain.port.outbound;

import com.cassio.polychat.domain.model.User;
import reactor.core.publisher.Mono;

public interface UserRepositoryPort {

    Mono<Boolean> existsByUsername(String username);
    Mono<User> save(User user);

}
