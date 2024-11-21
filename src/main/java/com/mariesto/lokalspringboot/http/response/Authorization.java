package com.mariesto.lokalspringboot.http.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
class Authorization {
    private String domain;
    private String addressPublic;
}
