package com.geekymon2.carmarketplace.core.autoconfiguration.security;

import com.geekymon2.carmarketplace.core.autoconfiguration.security.jwt.JwtTokenUtil;
import com.geekymon2.carmarketplace.core.autoconfiguration.security.properties.ApiConfig;
import com.geekymon2.carmarketplace.core.autoconfiguration.security.properties.JwtConfig;
import com.geekymon2.carmarketplace.core.autoconfiguration.security.validator.RouterValidator;
import com.geekymon2.carmarketplace.core.autoconfiguration.security.filter.ApiAuthFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
@EnableConfigurationProperties(ApiConfig.class)
@Slf4j
public class ApiAuthAutoConfig {

    @Autowired
    private ApiConfig apiConfig;

    @PostConstruct
    public void init() {
        if (apiConfig.getJwtConfig() == null) {
            throw new RuntimeException("Missing authentication configuration.");
        }

        log.info("Initializing API Authentication Auto Configuration");
        log.info("Is JWT Authentication turned off: {}", apiConfig.getJwtConfig().getJwtDisabled());
    }

    @Bean
    public RouterValidator routerValidator() {
        return new RouterValidator();
    }

    @Bean
    public JwtTokenUtil jwtTokenUtil(@Autowired JwtConfig config) {
        return new JwtTokenUtil(config);
    }

    @Bean
    public JwtConfig jwtConfig() {
        return new JwtConfig();
    }

    @Bean
    public FilterRegistrationBean<ApiAuthFilter> apiAuthenticationFilterBean(@Autowired JwtTokenUtil tokenUtil,
                                                                             @Autowired ApiConfig config,
                                                                             @Autowired RouterValidator validator) {
        FilterRegistrationBean<ApiAuthFilter> apiAuthenticationFilterBean = new FilterRegistrationBean<>();
        ApiAuthFilter filter = new ApiAuthFilter(tokenUtil, config, validator);

        apiAuthenticationFilterBean.setFilter(filter);

        return apiAuthenticationFilterBean;
    }
}
