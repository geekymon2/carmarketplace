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
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
@Slf4j
@EnableWebMvc
public class CorsFilterAutoConfig implements WebMvcConfigurer {

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
        log.info("CORS configuration enabled: {}", config.getEnabled());
        if (config.getEnabled()) {
            log.info("Applying CORS configuration from properties: {}", config.toString());
            if (config.getAllowCredentials() != null) corsConfig.setAllowCredentials(config.getAllowCredentials());
            if (config.getAllowedOrigins() != null) corsConfig.setAllowedOrigins(List.of(config.getAllowedOrigins()));
            if (config.getMaxAge() != null) corsConfig.setMaxAge(config.getMaxAge());
            if (config.getExposedHeader() != null) corsConfig.addExposedHeader(config.getExposedHeader());
            if (config.getAllowedHeader() != null) corsConfig.addAllowedHeader(config.getAllowedHeader());
            if (config.getAllowedMethod() != null) corsConfig.addAllowedMethod(config.getAllowedMethod());
            source.registerCorsConfiguration("/**", corsConfig);
        }
        return new CorsFilter(source);
    }
}