package com.cassio.polychat.adapter.inbound.http.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateUserRequest(
       @NotBlank @Size(min = 3, max = 100) String username,
       @NotBlank @Size(min = 8, max = 255) String password
) {}
