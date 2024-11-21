package com.mariesto.lokalspringboot.authentication;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;

@RequiredArgsConstructor
public class ApiToken implements AuthStrategy {
    private final String token;

    @Override
    public void applyAuthentication(HttpHeaders headers) {
        headers.set("X-Auth-Token", token);
    }
}
