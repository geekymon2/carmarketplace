package com.geekymon2.carmarketplace.core.autoconfiguration.cors.properties;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Getter
@Setter
@Configuration
@Primary
@ToString
@ConfigurationProperties(prefix = "app-config.cors-config")
public class CorsConfig {
    private Boolean enabled;
    private String[] allowedOrigins;
    private Long maxAge;
    private Boolean allowCredentials;
    private String allowedHeader;
    private String allowedMethod;
    private String exposedHeader;
}