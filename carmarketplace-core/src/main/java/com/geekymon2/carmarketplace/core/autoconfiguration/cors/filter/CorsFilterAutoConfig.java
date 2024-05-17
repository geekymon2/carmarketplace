package com.geekymon2.carmarketplace.core.autoconfiguration.cors.filter;

import com.geekymon2.carmarketplace.core.autoconfiguration.cors.properties.CorsConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import jakarta.annotation.PostConstruct;

import java.util.List;

@Configuration
@Slf4j
public class CorsFilterAutoConfig {

    @Autowired
    private final CorsConfig config;

    @PostConstruct
    public void init() {
        log.info("Initializing CORS Auto Configuration");
    }

    public CorsFilterAutoConfig(CorsConfig config) {
        this.config = config;
    }

    @Bean
    public CorsFilter corsFilter() {

        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        final CorsConfiguration corsConfig = new CorsConfiguration();
        log.info("Applying CORS configuration from properties: " + config.toString());
        corsConfig.setAllowCredentials(config.getAllowCredentials());
        corsConfig.setAllowedOrigins(List.of(config.getAllowedOrigins()));
        corsConfig.setMaxAge(config.getMaxAge());
        corsConfig.addExposedHeader(config.getExposedHeader());
        corsConfig.addAllowedHeader(config.getAllowedHeader());
        corsConfig.addAllowedMethod(config.getAllowedMethod());
        source.registerCorsConfiguration("/**", corsConfig);
        return new CorsFilter(source);
    }
}