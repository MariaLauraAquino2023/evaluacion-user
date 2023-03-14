package com.evaluacion.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationProperties {
    @Bean
    @ConfigurationProperties(prefix = "app.security")
    public SecurityProperties securityProperties() {
        return new SecurityProperties ();
    }
}
