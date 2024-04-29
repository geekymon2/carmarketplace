package com.geekymon2.carmarketplace.core.autoconfiguration.security.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Getter
@Setter
@Configuration
@Primary
@ConfigurationProperties(prefix = "jwt-config")
public class JwtConfig {
    private Boolean jwtDisabled;
    private String jwtSecret;
    private long jwtValidity;
}
