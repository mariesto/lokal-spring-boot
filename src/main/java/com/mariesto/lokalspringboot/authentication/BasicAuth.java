package com.mariesto.lokalspringboot.authentication;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;

@RequiredArgsConstructor
public class BasicAuth implements AuthStrategy {
    private final String username;
    private final String password;

    @Override
    public void applyAuthentication(HttpHeaders headers) {
        headers.setBasicAuth(username, password);
    }
}
