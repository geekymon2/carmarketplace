package com.geekymon2.carmarketplace.core.auth;

import com.geekymon2.carmarketplace.core.security.autoconfiguration.filter.ApiAuthenticationFilter;
import com.geekymon2.carmarketplace.core.security.autoconfiguration.properties.ApiConfig;
import com.geekymon2.carmarketplace.core.security.autoconfiguration.properties.SecurityConfig;
import com.geekymon2.carmarketplace.core.security.autoconfiguration.validator.RouterValidator;
import com.geekymon2.carmarketplace.core.security.jwt.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(value = {ApiConfig.class, SecurityConfig.class})
public class ApiAuthenticationConfigurations {

    @Bean
    public FilterRegistrationBean<ApiAuthenticationFilter> apiAuthenticationFilterBean(
            @Autowired JwtTokenUtil token, @Autowired ApiConfig config, @Autowired RouterValidator validator) {
        FilterRegistrationBean<ApiAuthenticationFilter> apiAuthenticationFilterBean = new FilterRegistrationBean<>();
        ApiAuthenticationFilter filter = new ApiAuthenticationFilter(token, config, validator);

        apiAuthenticationFilterBean.setFilter(filter);

        return apiAuthenticationFilterBean;
    }
}
