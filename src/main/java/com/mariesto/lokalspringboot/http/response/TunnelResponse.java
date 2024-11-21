package com.mariesto.lokalspringboot.http.response;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class TunnelResponse {
    private List<TunnelData> data = new ArrayList<>();
    private String message;
    private boolean success;
}

