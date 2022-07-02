package com.geekymon2.carmarketplace.core.security.autoconfiguration;

import com.geekymon2.carmarketplace.core.security.autoconfiguration.filter.ApiAuthFilter;
import com.geekymon2.carmarketplace.core.security.autoconfiguration.jwt.JwtTokenUtil;
import com.geekymon2.carmarketplace.core.security.autoconfiguration.validator.RouterValidator;
import com.geekymon2.carmarketplace.core.security.autoconfiguration.properties.ApiConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
@EnableConfigurationProperties(value = ApiConfig.class)
@Slf4j
public class ApiAuthAutoConfig {

    @Autowired
    ApiConfig config;

    @PostConstruct
    public void init() {
        log.info("Initializing API Authentication Auto Configuration");
    }

    @Bean
    public JwtTokenUtil jwtTokenUtil() {
        return new JwtTokenUtil();
    }

    @Bean
    public RouterValidator routerValidator() {
        return new RouterValidator();
    }

    @Bean
    public FilterRegistrationBean<ApiAuthFilter> apiAuthenticationFilterBean(@Autowired JwtTokenUtil tokenUtil, @Autowired RouterValidator validator) {
        FilterRegistrationBean<ApiAuthFilter> apiAuthenticationFilterBean = new FilterRegistrationBean<>();
        ApiAuthFilter filter = new ApiAuthFilter(tokenUtil, config, validator);

        apiAuthenticationFilterBean.setFilter(filter);

        return apiAuthenticationFilterBean;
    }

}
