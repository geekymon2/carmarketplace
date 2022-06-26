package com.geekymon2.carmarketplace.core.security.autoconfiguration.properties;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SecurityConfig {
    private Boolean jwtDisabled;
    private String jwtSecret;
    private int jwtValidity;
}