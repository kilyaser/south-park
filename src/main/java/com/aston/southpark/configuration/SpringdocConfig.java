package com.aston.southpark.configuration;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringdocConfig {
    @Bean
    public GroupedOpenApi customOpenApi() {
        return GroupedOpenApi.builder()
                .group("public-api")
                .packagesToScan("com.example.api.public")
                .pathsToMatch("/api/public/**")
                .build();
    }
}
