package com.cassio.polychat.domain.port.inbound;

import com.cassio.polychat.domain.model.User;
import reactor.core.publisher.Mono;

public interface CreateUserUseCase {

    Mono<User> create(String username, String rawPassword);

}
