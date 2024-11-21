package com.mariesto.lokalspringboot.http.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class TunnelData {
    private String id;
    private String name;
    private String tunnelType;
    private String protocol;
    private String localAddress;
    private String localDirectory;
    private String addressMdns;
    private String addressPublic;
    private int addressPublicPort;
    private String addressTunnel;
    private int addressTunnelPort;
    private String cfTunnelAddress;
    private String cfTunnelStatus;
    private String serverId;
    private String subdomain;
    private Object options;
    private Object optionsText;
    private boolean aesOverTls;
    private boolean inspect;
    private String status;
    private Server server;
    private Authorization authorization;
    private long createdAt;
    private List<Inspection> inspections = new ArrayList<>();
    private boolean enablePublicAddress;
}
