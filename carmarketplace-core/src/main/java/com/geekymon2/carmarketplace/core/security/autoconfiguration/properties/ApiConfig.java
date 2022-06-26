package com.geekymon2.carmarketplace.core.security.autoconfiguration.properties;

import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "api-config", ignoreInvalidFields = true)
@Getter
public class ApiConfig {
    private SecurityConfig security;
}
