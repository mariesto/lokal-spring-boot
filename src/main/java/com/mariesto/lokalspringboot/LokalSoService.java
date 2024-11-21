package com.mariesto.lokalspringboot;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mariesto.lokalspringboot.config.TunnelConfig;
import com.mariesto.lokalspringboot.http.response.TunnelData;
import com.mariesto.lokalspringboot.http.response.TunnelResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Map;

@Service
@Slf4j
public class LokalSoService {

    public final RestTemplate restTemplate;
    public final ObjectMapper objectMapper;

    private static final String SERVER_MIN_VERSION = "v0.6.0";
    private static final String USER_AGENT = "Lokal Spring Boot - github.com/lokal-so/lokal-spring-boot";

    public LokalSoService(RestTemplate restTemplate, ObjectMapper objectMapper) {
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
    }

    public TunnelResponse startTunneling(TunnelConfig tunnelConfig) {
        Map<String, Object> request = objectMapper.convertValue(tunnelConfig, new TypeReference<>() {});
        URI uri = URI.create("http://localhost:6174/api/tunnel/start");

        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.USER_AGENT, USER_AGENT);
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Object> requestEntity = new HttpEntity<>(request, headers);

        ResponseEntity<TunnelResponse> response = restTemplate.exchange(uri, HttpMethod.POST, requestEntity, TunnelResponse.class);

        if (tunnelConfig.isShowBanner()) {
            TunnelData tunnelData = response.getBody().getData().get(0);
            printBanner(tunnelData.getAddressMdns(), tunnelData.getAddressPublic());
        }
        return response.getBody();
    }

    public TunnelResponse stopTunneling(String tunnelId) {
        restTemplate.delete(URI.create("http://localhost:6174/api/tunnel/delete?tunnel_id=" + tunnelId));
        TunnelResponse response = new TunnelResponse();
        response.setSuccess(Boolean.TRUE);
        response.setMessage("Tunnel stopped");
        return response;
    }

    private void printBanner(String lanAddress, String publicAddress) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("""
                \n
                    ,--.       ,--.           ,--.                  \s
                    |  | ,---. |  |,-. ,--,--.|  |     ,---.  ,---. \s
                    |  || .-. ||     /' ,-.  ||  |    (  .-' | .-. |\s
                    |  |' '-' '|  \\  \\\\ '-'  ||  |.--..-')' '-' '\s
                    `--' `---' `--'`--'`--`--'`--''--'`----'  `---' \s
                """);
        stringBuilder.append("\033[1;31mMinimum Lokal Client : " + SERVER_MIN_VERSION);
        if (!lanAddress.isEmpty()) {
            stringBuilder.append("\n\033[1;34mLAN Address : ").append(lanAddress);
        }
        if (!publicAddress.isEmpty()) {
            stringBuilder.append("\n\033[1;32mPUBLIC Address : ").append(publicAddress);
        }
        log.info(stringBuilder.toString());
    }
}
