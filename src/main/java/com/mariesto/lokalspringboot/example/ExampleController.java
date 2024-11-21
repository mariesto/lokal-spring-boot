package com.mariesto.lokalspringboot.example;

import com.mariesto.lokalspringboot.LokalSoService;
import com.mariesto.lokalspringboot.config.TunnelConfig;
import com.mariesto.lokalspringboot.constant.TunnelType;
import com.mariesto.lokalspringboot.http.request.Options;
import com.mariesto.lokalspringboot.http.response.TunnelResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/tunnels", produces = "application/json")
public class ExampleController {
    LokalSoService lokalSoService;

    public ExampleController(LokalSoService lokalSoService) {
        this.lokalSoService = lokalSoService;
    }

    @PostMapping("/start")
    public ResponseEntity<TunnelResponse> startTunnel() {
        TunnelConfig tunnelConfig = TunnelConfig.builder()
                .name("spring-tunnel-v1")
                .addressMdns("my-spring-v1.local")
                .build();
        return ResponseEntity.ok(lokalSoService.startTunneling(tunnelConfig));
    }

    @PostMapping("/stop")
    public ResponseEntity<TunnelResponse> stopTunnel(@RequestParam String tunnelId) {
        return ResponseEntity.ok(lokalSoService.stopTunneling(tunnelId));
    }

    @GetMapping("/basic-auth")
    public TunnelResponse basicAuthTunnel(
            @RequestHeader(value = "X-Auth-Username") String username,
            @RequestHeader(value = "X-Auth-Password") String password
    ) {
        Options options = new Options();
        options.setBasicAuth(List.of(username + ":" + password));

        TunnelConfig tunnelConfig = TunnelConfig.builder()
                .name("spring-tunnel-basic-auth")
                .addressMdns("my-spring-v2.local")
                .localAddress("localhost:8080")
                .tunnelType(TunnelType.HTTP.name())
                .options(options)
                .build();
        return lokalSoService.startTunneling(tunnelConfig);
    }

    @GetMapping("/token")
    public TunnelResponse tokenAuthTunnel(@RequestHeader(value = "X-Auth-Token") String token) {
        Options options = new Options();
        options.setHeaderKey(List.of(token));

        TunnelConfig tunnelConfig = TunnelConfig.builder()
                .name("spring-tunnel-token")
                .addressMdns("my-spring-v3.local")
                .localAddress("localhost:8080")
                .tunnelType(TunnelType.HTTP.name())
                .options(options)
                .build();
        return lokalSoService.startTunneling(tunnelConfig);
    }
}
