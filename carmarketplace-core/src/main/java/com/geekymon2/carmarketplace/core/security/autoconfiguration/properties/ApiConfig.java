package com.geekymon2.carmarketplace.core.security.autoconfiguration.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties(prefix = "api-config")
public class ApiConfig {
    private SecurityConfig securityConfig;
}
