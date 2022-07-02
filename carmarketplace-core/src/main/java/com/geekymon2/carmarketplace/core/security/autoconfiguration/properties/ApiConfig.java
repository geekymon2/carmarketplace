package com.geekymon2.carmarketplace.core.security.autoconfiguration.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
public class ApiConfig {
    private SecurityConfig securityConfig;
}
