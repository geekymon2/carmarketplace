package com.geekymon2.carmarketplace.core.autoconfiguration.config;

import com.geekymon2.carmarketplace.core.autoconfiguration.cors.properties.CorsConfig;
import com.geekymon2.carmarketplace.core.autoconfiguration.security.properties.JwtConfig;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@Primary
@ConfigurationProperties(prefix = "app-config")
@Getter
@Setter
public class ApplicationConfiguration {
    private JwtConfig jwtConfig;
    private CorsConfig corsConfig;
}