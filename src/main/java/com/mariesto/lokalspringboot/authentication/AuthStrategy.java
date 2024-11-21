package com.mariesto.lokalspringboot.authentication;

import org.springframework.http.HttpHeaders;

public interface AuthStrategy {
    void applyAuthentication(HttpHeaders headers);
}
