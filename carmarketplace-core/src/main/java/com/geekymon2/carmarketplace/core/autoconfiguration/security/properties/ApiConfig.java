package com.geekymon2.carmarketplace.core.autoconfiguration.security.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "api-config")
public class ApiConfig {
    private JwtConfig jwtConfig;
}
