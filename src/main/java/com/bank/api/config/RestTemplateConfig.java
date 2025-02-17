package com.bank.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
 
/**
 * @author Eric
 * @date 2023-08-03 9:37
 */
@Configuration
public class RestTemplateConfig {
 
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
 
}