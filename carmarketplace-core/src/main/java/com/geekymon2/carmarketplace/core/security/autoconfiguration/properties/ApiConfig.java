package com.geekymon2.carmarketplace.core.security.autoconfiguration.properties;

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
