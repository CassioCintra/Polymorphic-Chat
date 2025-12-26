package com.cassio.polychat.domain.model;

import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.UUID;

@Data
@Builder
public class User {
    private final UUID id;
    private final String username;
    private final String password;
    private final Instant createdAt;

    public static User create(String username, String encodedPassword) {
        return User.builder()
                .id(null)
                .username(username)
                .password(encodedPassword)
                .createdAt(Instant.now())
                .build();
    }
}
