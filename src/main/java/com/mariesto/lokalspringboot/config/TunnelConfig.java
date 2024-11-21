package com.mariesto.lokalspringboot.config;

import com.mariesto.lokalspringboot.http.request.Options;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class TunnelConfig {
    private String name;

    private String tunnelType;

    private String publicAddress;

    private String localAddress;

    private String addressMdns;

    private boolean inspect;

    private boolean ignoreDuplicate;

    private boolean showBanner;

    private Options options;
}
