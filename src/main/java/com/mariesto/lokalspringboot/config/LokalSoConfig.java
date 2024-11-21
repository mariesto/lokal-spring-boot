package com.mariesto.lokalspringboot.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.mariesto.lokalspringboot.LokalSoService;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.AbstractJackson2HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

@Configuration
public class LokalSoConfig {

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        builder.messageConverters(messageConverter());
        return builder.build();
    }

    @Bean
    public AbstractJackson2HttpMessageConverter messageConverter() {
        MappingJackson2HttpMessageConverter messageConverter = new MappingJackson2HttpMessageConverter();
        messageConverter.setObjectMapper(objectMapper());
        return messageConverter;
    }

    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE);
        return objectMapper;
    }

    @Bean
    public LokalSoService lokalSoService(RestTemplate restTemplate, ObjectMapper objectMapper) {
        return new LokalSoService(restTemplate, objectMapper);
    }
}
