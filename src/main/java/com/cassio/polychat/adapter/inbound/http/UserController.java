package com.cassio.polychat.adapter.inbound.http;

import com.cassio.polychat.adapter.inbound.http.dto.CreateUserRequest;
import com.cassio.polychat.domain.port.inbound.CreateUserUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final CreateUserUseCase createUserUseCase;

    @PostMapping
    public Mono<ResponseEntity<Void>> create(@RequestBody @Valid CreateUserRequest request) {
        return createUserUseCase.create(request.username(), request.password())
                .thenReturn(
                    ResponseEntity.status(HttpStatus.CREATED).build()
                );
    }
}
