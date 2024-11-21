package com.mariesto.lokalspringboot.http.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Server {
    private String serverId;
    private String name;
    private String serverHost;
    private int serverPort;
    private int serverHttpPort;
    private int latency;
    private String secretKey;
    private String encryptionKey;
    private String domain;
    private long createdAt;
    private boolean readOnly;
    private String serverOwner;
}
