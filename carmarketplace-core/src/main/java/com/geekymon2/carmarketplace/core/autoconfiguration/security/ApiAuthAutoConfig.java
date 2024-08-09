package com.geekymon2.carmarketplace.core.autoconfiguration.security;

import com.geekymon2.carmarketplace.core.autoconfiguration.security.jwt.JwtTokenUtil;
import com.geekymon2.carmarketplace.core.autoconfiguration.security.properties.JwtConfig;
import com.geekymon2.carmarketplace.core.autoconfiguration.security.validator.RouterConfig;
import com.geekymon2.carmarketplace.core.autoconfiguration.security.validator.RouterValidator;
import com.geekymon2.carmarketplace.core.autoconfiguration.security.filter.ApiAuthFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import jakarta.annotation.PostConstruct;

@Configuration
@EnableConfigurationProperties(JwtConfig.class)
@Slf4j
public class ApiAuthAutoConfig {

    @Autowired
    private JwtConfig jwtConfig;

    @PostConstruct
    public void init() {
        if (jwtConfig.getJwtValidity() == 0 || jwtConfig.getJwtDisabled() == null || jwtConfig.getJwtSecret() == null) {
            throw new RuntimeException("Missing JWT configuration. Please provide JWT properties in configuration file.");
        }

        log.info("Initializing API Authentication Auto Configuration");
        log.info("Is JWT Authentication turned off: {}", jwtConfig.getJwtDisabled());
        log.info("JWT validity: {}", jwtConfig.getJwtValidity());
    }

    @Bean
    public RouterValidator routerValidator(@Autowired RouterConfig config) {
        return new RouterValidator(config);
    }

    @Bean
    public JwtTokenUtil jwtTokenUtil(@Autowired JwtConfig config) {
        return new JwtTokenUtil(config);
    }

    @Bean
    public FilterRegistrationBean<ApiAuthFilter> apiAuthenticationFilterBean(@Autowired JwtTokenUtil tokenUtil,
                                                                             @Autowired JwtConfig config,
                                                                             @Autowired RouterValidator validator) {
        FilterRegistrationBean<ApiAuthFilter> apiAuthenticationFilterBean = new FilterRegistrationBean<>();
        ApiAuthFilter filter = new ApiAuthFilter(tokenUtil, config, validator);

        apiAuthenticationFilterBean.setFilter(filter);

        return apiAuthenticationFilterBean;
    }
}
