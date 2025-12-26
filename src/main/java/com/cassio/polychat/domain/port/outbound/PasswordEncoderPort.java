package com.cassio.polychat.domain.port.outbound;

public interface PasswordEncoderPort {

    String encode(String password);
}
