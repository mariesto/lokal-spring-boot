package com.mariesto.lokalspringboot.http.request;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Options {
    private List<String> basicAuth = new ArrayList<>();
    private List<String> cidrAllow = new ArrayList<>();
    private List<String> cidrDeny = new ArrayList<>();
    private List<String> requestHeaderAdd = new ArrayList<>();
    private List<String> requestHeaderRemove = new ArrayList<>();
    private List<String> responseHeaderAdd = new ArrayList<>();
    private List<String> responseHeaderRemove = new ArrayList<>();
    private List<String> headerKey = new ArrayList<>();
}
