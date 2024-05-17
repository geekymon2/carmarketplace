package com.geekymon2.carmarketplace.core.autoconfiguration.cors;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import jakarta.annotation.PostConstruct;

import java.util.Arrays;
import java.util.List;

@Configuration
@Slf4j
public class CorsFilterAutoConfig {

    @PostConstruct
    public void init() {
        log.info("Initializing CORS Auto Configuration");
    }

    @Bean
    public CorsFilter corsFilter() {

        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        final CorsConfiguration config = new CorsConfiguration();
        log.info("Adding CORS config.");
        config.setAllowCredentials(true);
        config.setAllowedOrigins(List.of("http://localhost:4200"));
        config.setMaxAge(3600L);
        config.addExposedHeader("X-Get-Header");
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}