package com.mycompany.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.client.RestClient;

@Configuration
@EnableJpaAuditing
@PropertySource("classpath:application.yml")
public class TaskServiceConfig {

    @Value("${spring.connections.employee-base-url}")
    String baseUrl;

    @Bean
    public RestClient restClient() {
        return RestClient.create(baseUrl);
    }
}
