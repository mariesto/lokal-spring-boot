package com.mariesto.lokalspringboot.http.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Inspection {
    private long endAt;
    private String ipAddress;
    private String requestHeader;
    private String requestMethod;
    private String requestRawHttp;
    private String requestScheme;
    private String requestUri;
    private int responseCode;
    private String responseCodeText;
    private String responseHeader;
    private String responseRawHttp;
    private String sessionId;
    private long startAt;
    private String tunnelId;
}
