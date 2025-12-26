package com.cassio.polychat.application.service;

import com.cassio.polychat.domain.model.User;
import com.cassio.polychat.domain.port.inbound.CreateUserUseCase;
import com.cassio.polychat.domain.port.outbound.PasswordEncoderPort;
import com.cassio.polychat.domain.port.outbound.UserRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CreateUserService implements CreateUserUseCase {

    private final UserRepositoryPort userRepository;
    private final PasswordEncoderPort passwordEncoder;

    @Override
    public Mono<User> create(String username, String rawPassword) {
        return userRepository.existsByUsername(username)
                .flatMap(exists -> {
                    if (exists) {
                        return Mono.error(new IllegalStateException("Username already exists"));
                    }

                    String encodedPassword = passwordEncoder.encode(rawPassword);
                    User user = User.create(username, encodedPassword);
                    return userRepository.save(user);
                });
    }
}

